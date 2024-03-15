package basic;

import java.util.Scanner;

public class RotateANumber
{
    /*
    Input : 12345
            3
    Output : 34512

    Input : 12345
            6
    Output : 51234

    Input : 12345
            -2
    Output : 34512
     */

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int k = in.nextInt();
        System.out.println(rotate(number, k));
    }
    public static int rotate(int number, int k) {
        //find the no.of digits
        int noOfDigits = 0;
        int temp = number;
        while(temp != 0) {
            temp /= 10;
            noOfDigits++;
        }
        //in case of k is greater than no.of digits, it's just a cycle
        k = k % noOfDigits;
        // Negative rotations are converted to respective positive equivalents
        if(k < 0) k += noOfDigits;

        /*
        12345 & 2
        123 45
            = 12345 / 100 -> 123 step1
            = 12345 % 100 = 45 step2
            = 45 * 1000 + 123 (step2 * 10 ^ noOfDigits in step1 + leftPart)
         */
        int n1 = (int) Math.pow(10, k);
        int n2 = (int) Math.pow(10, noOfDigits - k);

        return (number % n1 * n2) + (number / n1);
    }
}
