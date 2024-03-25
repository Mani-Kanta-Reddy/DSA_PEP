package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMax {
    /*
    Input : 8
            9 6 2 4 5 3 1 7
            3
    Output : 9 6 5 5 5 7
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        slidingWindowMax(arr, k);
    }
    public static void slidingWindowMax(int[] arr, int k) {
        int[] ngetr = new int[arr.length];
        ngetr[arr.length - 1] = arr.length; // there are no elements to the right of last element
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1); // stack contents are indices only
        for(int i = arr.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            ngetr[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        //slide the window and find the largest element
        for(int i = 0, j = 0; i <= arr.length - k; i++) {
            j = i;
            while(ngetr[j] < i + k) {
                j = ngetr[j];
            }
            System.out.print(arr[j] + " ");
        }
    }
}
