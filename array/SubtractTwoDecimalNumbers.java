package array;

import java.util.Scanner;

public class SubtractTwoDecimalNumbers {
    /*
    Input : 3 (digits of first Number)
            1 0 0 (number itself)
            1 (digits of second number)
            9   (number itself)
    Note : n1 >= n2
    Output : 91
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
        }
        subtract(arr1, arr2);
    }
    public static void subtract(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length]; //since n1 is greater than or equal to n2
        int borrow = 0;

        int i = arr1.length - 1, j = arr2.length - 1, k = res.length - 1;
        while(k >= 0) {
            int d1 = arr1[i] + borrow; //subtract borrow from d1 (don't confuse with + borrow will be coming as negative)
            int d2 = j >= 0 ? arr2[j] : 0;
            int d;
            if(d1 >= d2) {
                borrow = 0;
                d = d1 - d2;
            } else {
                borrow = -1;
                d = d1 + 10 - d2;
            }
            res[k] = d;

            i--; j--; k--;
        }

        // we don't wanna print leading zeroes
        for (int val : res) {
            if(val == 0) continue;
            System.out.print(val);
        }
    }
}
