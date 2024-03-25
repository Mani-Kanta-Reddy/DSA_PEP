package array;

import java.util.Scanner;

public class AddTwoDecimalNumbers
{
    /*
    Input : 5 (size of n1)
            9 3 4 6 8
            4 (size of n2)
            1 9 8 8
    Output : 95456
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < n1; i++) {
            arr1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
        }
        add(arr1, arr2);
    }
    public static void add(int[] arr1, int[] arr2) {
        int max = Math.max(arr1.length, arr2.length);
        int[] res = new int[max];
        int carry = 0;
        int i = arr1.length - 1, j = arr2.length - 1, k = max - 1;
        while(k >= 0) {
            int d = carry;
            if(i >= 0) {
                d += arr1[i];
            }
            if(j >= 0) {
                d += arr2[j];
            }

            int curr = d % 10;
            carry = d / 10;
            res[k] = curr;

            i--; j--; k--;
        }

        if(carry > 0) {
            System.out.print(carry);
        }

        for (int val : res) {
            System.out.print(val);
        }
    }
}
