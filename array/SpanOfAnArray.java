package array;

import java.util.Scanner;

public class SpanOfAnArray
{
    /*
    Input : 5 (array size)
            10 (elements)
            9
            23
            99
            45
    Output : (99 - 9) = 90
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(computeSpan(arr));
    }
    public static int computeSpan(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min;
    }
}
