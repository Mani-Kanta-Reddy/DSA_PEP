package stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvalAndConversion {
    /*
    Input : 264*8/+3-
    Output :
            Result :
            Infix :
            Prefix :
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String postfixExp = sc.nextLine();
        evalAndConvert(postfixExp);
    }
    public static void evalAndConvert(String postfixExp) {
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();
        for(int i = 0; i < postfixExp.length(); i++) {
            char currCh = postfixExp.charAt(i);
            // if currCh is operator eval and update infix and prefix expressions
            if(currCh == '+' || currCh == '-' || currCh == '*' || currCh == '/') {
                //pop two items
                int v2 = valueStack.pop();
                int v1 = valueStack.pop();
                int res = operate(v1, v2, currCh);
                valueStack.push(res);
                // infix expression update
                String infixV2 = infixStack.pop();
                String infixV1 = infixStack.pop();
                String infixRes = "(" + infixV1 + currCh + infixV2 + ")";
                infixStack.push(infixRes);
                // prefix expression update
                String prefixV2 = prefixStack.pop();
                String prefixV1 = prefixStack.pop();
                String prefixRes = currCh + prefixV1 + prefixV2;
                prefixStack.push(prefixRes);
            }
            // else (currCh is operand) simply push on to the stacks
            else {
                valueStack.push(currCh - '0');
                infixStack.push(currCh + "");
                prefixStack.push(currCh + "");
            }
        }
        System.out.printf("Result : %d \n Infix : %s \n Prefix : %s", valueStack.pop(), infixStack.pop(), prefixStack.pop());
    }
    private static int operate(int v1, int v2, char operator) {
        if(operator == '+') return v1 + v2;
        if(operator == '-') return v1 - v2;
        if(operator == '*') return v1 * v2;
        return v1 / v2;
    }
}
