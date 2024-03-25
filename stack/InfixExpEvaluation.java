package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixExpEvaluation {
    /*
    Input : 2+3-(3*4)/2
    Output : -1

    Note : single digits only, valid expression only, +, -, *, / operators only
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(evaluateExpression(expression));
    }
    public static int evaluateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if(currChar == '(') {
                // just push on to the operators stack
                operators.push(currChar);
            }
            else if(currChar == ')') {
                // evaluate
                while(operators.peek() != '(') {
                    char op = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int temp = operate(op, val1, val2);
                    operands.push(temp);
                }
                // pop open brace also
                operators.pop();
            }
            else if(currChar >= '0' && currChar <= '9') {
                operands.push(currChar - '0');
            }
            // if arithmetic operator (allowed only +, -, *, /)
            else if(currChar == '+' || currChar == '-' || currChar == '*' || currChar == '/') {
                while(!operators.isEmpty() && operators.peek() != '(' && priority(operators.peek()) >= priority(currChar)) {
                    char op = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int temp = operate(op, val1, val2);
                    operands.push(temp);
                }
                operators.push(currChar);
            }
        }

        // you may end up having few operators left on the stack
        while(!operators.isEmpty()) {
            char op = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            int temp = operate(op, val1, val2);
            operands.push(temp);
        }

        return operands.pop();
    }

    private static int priority(char ch) {
        if(ch == '+' || ch == '-') {
            return 1;
        }
        if(ch == '*' || ch == '/')
            return 2;
        else return 0;
    }

    private static int operate(char op, int val1, int val2) {
        if(op == '+') {
            return val1 + val2;
        } else if(op == '-') {
            return val1 - val2;
        } else if(op == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }
}
