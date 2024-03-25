package stack;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    /*
    Input : 8
            9    6   2    4     5   3     1    7
            |
            |                                  |
            |    |                             |
            |    |                             |
            |    |              |              |
            |    |         |    |              |
            |    |         |    |    |         |
            |    |    |    |    |    |         |
            |    |    |    |    |    |    |    |

            9    12  12    8    5    9    8    7

     Output : 12
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(largestAreaEnclosed(arr));
    }

    public static int largestAreaEnclosed(int[] arr) {
        // indices of next smaller elements to right
        int[] nsetrIndices = new int[arr.length];
        nsetrIndices[arr.length - 1] = arr.length;

        // indices of next smaller elements to left
        int[] nsetlIndices = new int[arr.length];
        nsetlIndices[0] = -1;

        // First fill next smaller elements to right
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1); // stack contents are indices only
        for(int i = arr.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsetrIndices[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        // now fill next smaller elements to left
        stack = new Stack<>();
        stack.push(0);  // stack contents are indices only
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsetlIndices[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int sitr = nsetrIndices[i];
            int sitl = nsetlIndices[i];
            int diff = sitr - sitl - 1;
            int area = arr[i] * diff;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

}
