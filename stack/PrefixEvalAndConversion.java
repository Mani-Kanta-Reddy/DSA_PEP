package stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalAndConversion {
    /*
    Input : -+2/*6483
    Output :
            Result :
            Infix :
            Postfix :
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prefixExp = sc.nextLine();
        evalAndConvert(prefixExp);
    }
    private static void evalAndConvert(String prefixExp) {
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();
        // Note : traversing from right to left
        for(int i = prefixExp.length() - 1; i >= 0; i--) {
            char currCh = prefixExp.charAt(i);
            if(currCh == '+' || currCh == '-' || currCh == '*' || currCh == '/') {
                // pop two items
                //Note : since iteration is from right to left top of stack is v1
                int v1 = valueStack.pop();
                int v2 = valueStack.pop();
                int res = operate(v1, v2, currCh);
                valueStack.push(res);
                String infixV1 = infixStack.pop();
                String infixV2 = infixStack.pop();
                String infixRes = "(" + infixV1 + currCh + infixV2 + ")";
                infixStack.push(infixRes);
                String postfixV1 = postfixStack.pop();
                String postfixV2 = postfixStack.pop();
                String postfixRes = postfixV1 + postfixV2 + currCh;
                postfixStack.push(postfixRes);
            } else {
                valueStack.push(currCh - '0');
                infixStack.push(currCh + "");
                postfixStack.push(currCh + "");
            }
        }
        System.out.printf("Result : %d \n Infix : %s \n Postfix : %s", valueStack.pop(), infixStack.pop(), postfixStack.pop());
    }

    private static int operate(int v1, int v2, char operator) {
        if(operator == '+') return v1 + v2;
        if(operator == '-') return v1 - v2;
        if(operator == '*') return v1 * v2;
        return v1 / v2;
    }
}
