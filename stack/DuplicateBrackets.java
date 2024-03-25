package stack;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    /*
    Input : (a + b) + ((c + d)) // c + d has redundant parens
    Output : true

    Input : ((a + b) + (c + d))
    Output : false
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println(hasDuplicateBraces(expression));
    }
    public static boolean hasDuplicateBraces(String expression) {
        boolean hasDuplicates = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == ')') {
                if(stack.peek() == '(') {
                    hasDuplicates = true;
                    break;
                }
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return hasDuplicates;
    }
}
