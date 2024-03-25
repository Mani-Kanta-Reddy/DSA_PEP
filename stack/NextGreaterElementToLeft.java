package stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToLeft {
    /*
    Input :  6
             9 6 8 1 11 3
    Output : -1 9 9 8 -1 11
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : nextGreaterElementToLeft(arr)) {
            System.out.print(ele + " ");
        }
        System.out.println();
        // right to left solution
        for (int ele : nextGreaterElementToLeftAlternative(arr)) {
            System.out.print(ele + " ");
        }
    }

    public static int[] nextGreaterElementToLeftAlternative(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);  // Note : stack contents are indices
        for(int i = arr.length - 2; i >= 0; i--) {
            int curr = arr[i];
            while(!stack.isEmpty() && curr > arr[stack.peek()]) {
                res[stack.peek()] = curr;
                stack.pop();
            }
            stack.push(i);
        }
        // stack may contain indices for which there is no larger element to left
        while(!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
    public static int[] nextGreaterElementToLeft(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = -1; // you can't have elements to the left for first element
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
