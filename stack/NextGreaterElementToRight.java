package stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToRight {
    /*
    Input : 6 (no of elements)
            9 6 2 1 7 3

    Output : -1 7 7 7 -1 -1
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // right to left approach
        for (int ele : nextGreaterElementToRight(arr)) {
            System.out.print(ele + " ");
        }
        System.out.println();
        // left to right solve
        for (int ele : nextGreaterElementToRightAlternate(arr)) {
            System.out.print(ele + " ");
        }
    }

    public static int[] nextGreaterElementToRightAlternate(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // Note : stack contents are indices only
        int[] res = new int[arr.length];
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        // you may have elements left on stack for which there is no larger to it's right
        while(!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    public static int[] nextGreaterElementToRight(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;   // no elements to the right end
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        for(int i = arr.length - 2; i >= 0; i--) {
            int curr = arr[i];
            //if you find elements that are smaller pop
            while(!stack.isEmpty() && curr >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
