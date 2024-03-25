package stack;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    /*
    Input : 6 (n)
            9 6 2 1 7 3

            |
            |
            |               |
            |   |           |
            |   |           |
            |   |           |
            |   |           |   |
            |   |   |       |   |
            |   |   |   |   |   |
            1  1-0 2-1 3-2 4-0 5-4

    Output: 1   1   1   1   4   1
    Note : you can think of tallest buildings cast their shadow to left and covers smaller building (light source is right)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int span : findStockSpans(arr)) {
            System.out.print(span + " ");
        }
    }
    public static int[] findStockSpans(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = 1; // there are no elements to left of the first element
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  //Note : stack contents are indices
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return res;
    }
}
