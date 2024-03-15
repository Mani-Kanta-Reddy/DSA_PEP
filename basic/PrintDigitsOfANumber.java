package basic;

import java.util.Scanner;

public class PrintDigitsOfANumber
{
    /*
        Input : 123
        Output : 1 2 3
         */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        // first find the no.of digits in the given number
        int noOfDigits = 0;
        int temp = number;

        while(temp != 0) {
            temp /= 10;
            noOfDigits++;
        }

        while(number != 0) {
            int divisor = (int) Math.pow(10, noOfDigits - 1);
            int quotient = number / divisor;
            System.out.printf("%d ", quotient);
            number %= divisor;
            noOfDigits--;
        }
    }
}
