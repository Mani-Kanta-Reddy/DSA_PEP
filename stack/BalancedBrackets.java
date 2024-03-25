package stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    /*
    Input : {(a + b) + [c + d]}
    Output : true

    sample 2 : {(a + b] + (c + d)}
               false
    sample 3 : (a + b)]
               false
    sample 4 : {(a + b)
               false
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println(areBracketsBalanced(expression));
    }
    public static boolean areBracketsBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            //opening braces simply be pushed on to the stack
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // handle closing braces
            else if(ch == ')') {
                boolean res = handleClosingBrace(stack, '(');
                if(!res) return false;
            } else if (ch == '}') {
                boolean res = handleClosingBrace(stack, '{');
                if(!res) return false;
            } else if (ch == ']') {
                boolean res = handleClosingBrace(stack, '[');
                if(!res) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean handleClosingBrace(Stack<Character> stack, char correspondingOpeningBrace) {
        // received a closing brace but stack is empty, means extra closing braces
        if(stack.isEmpty())
            return false;

        char peek = stack.peek();
        // opening & closing pair doesn't match return false -> mismatch scenario
        if (peek != correspondingOpeningBrace)
            return false;

        // opening & closing pair match -> pop & return true
        stack.pop();
        return true;

    }

}
