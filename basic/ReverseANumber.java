package basic;

import java.util.Scanner;

public class ReverseANumber
{
    /*
    Input : 123
    Output : 321
    */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(reverseNumber(number));
    }
    public static int reverseNumber(int number) {
        //first find the no.of digits
        int noOfDigits = 0;
        int temp = number;
        while(temp != 0) {
            temp /= 10;
            noOfDigits++;
        }

        int result = 0;
        int multiplier = (int) Math.pow(10, noOfDigits - 1);
        while(number != 0) {
            int remainder = number % 10;
            result += remainder * multiplier;
            multiplier /= 10;
            number /= 10;
        }
        return result;
    }
}
