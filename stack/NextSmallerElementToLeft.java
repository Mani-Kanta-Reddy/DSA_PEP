package stack;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementToLeft {
    /*
    Input : 6
            6 3 9 3 7 1
    Output : -1 -1 3 -1 3 -1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : nextSmallerElementToLeft(arr)) {
            System.out.print(ele + " ");
        }
    }
    public static int[] nextSmallerElementToLeft(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = -1;    // there will not be any elements to the left of first element
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
