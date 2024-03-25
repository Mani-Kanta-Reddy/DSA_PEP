package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPreAndPostConversion {
    /*
    Input : a * (b - c) / d + e
    Output :
            Prefix =
            Postfix =

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infixExp = sc.nextLine();
        findPrefixAndPostfix(infixExp);
    }
    private static void findPrefixAndPostfix(String infixExp) {
        Stack<Character> operators = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for(int i = 0; i < infixExp.length(); i++) {
            char currCh = infixExp.charAt(i);
            if(currCh == '(') {
                operators.push(currCh);
            } else if(currCh == ')') {
                while(operators.peek() != '(') {
                    buildPreAndPost(operators, prefix, postfix);
                }
                // finally pop open brace
                operators.pop();
            } else if(currCh == '+' || currCh == '-' || currCh == '*' || currCh == '/') {
                while (!operators.isEmpty() && operators.peek() != '(' && priority(currCh) <= priority(operators.peek())) {
                    buildPreAndPost(operators, prefix, postfix);
                }
                operators.push(currCh);
            }
            // a, b, c.. operands
            else {
                prefix.push(currCh + "");
                postfix.push(currCh + "");
            }
        }

        // stack may have remaining operators
        while(!operators.isEmpty()) {
            buildPreAndPost(operators, prefix, postfix);
        }
        // finally print the answer
        System.out.println("Prefix = " + prefix.pop());
        System.out.println("Postfix = " + postfix.pop());
    }

    private static void buildPreAndPost(Stack<Character> operators, Stack<String> prefix, Stack<String> postfix) {
        char operator = operators.pop();
        String pre2 = prefix.pop();
        String pre1 = prefix.pop();
        String preTemp = operator + pre1 + pre2;
        prefix.push(preTemp);
        String post2 = postfix.pop();
        String post1 = postfix.pop();
        String postTemp = post1 + post2 + operator;
        postfix.push(postTemp);
    }

    private static int priority(char operator) {
        if(operator == '+' || operator == '-') return 1;
        if(operator == '*' || operator == '/') return 2;
        return 0;
    }
}
