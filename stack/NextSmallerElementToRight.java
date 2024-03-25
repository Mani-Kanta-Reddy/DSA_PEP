package stack;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementToRight {
    /*
    Input : 6
            9 6 2 1 7 3

    Output : 6 2 1 -1 3 -1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // right to left solution
        for (int ele : nextSmallerElementToRight(arr)) {
            System.out.print(ele + " ");
        }

        System.out.println();
        //left to right solution
        for (int ele : nextSmallerElementToRightAlternative(arr)) {
            System.out.print(ele + " ");
        }
    }
    public static int[] nextSmallerElementToRightAlternative(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);   // Note : stack contents are indices
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        // stack may still contain indices for which there is smaller element to right
        while(!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
    public static int[] nextSmallerElementToRight(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        for(int i = arr.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
