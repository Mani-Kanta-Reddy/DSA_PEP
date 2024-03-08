package basic;

import java.util.Scanner;

public class InverseOfANumber
{
    /*
    given a number eg.,
    Input :         2   3   1   5   4   6
    Position :      6   5   4   3   2   1
    Output :        1   3   2   5   6   4

     */
    public static void main(String[] args)
    {
        // The idea is to extract each digit from left to right and build the inverse of the number
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int result = findInverse(number);
        System.out.println(result);
    }

    public static int findInverse(int number) {
        int result = 0;
        int position = 1;

        while(number != 0) {
            //extract the last digit
            int originalDigit = number % 10;
            //swap position and digits b/w original and inversed
            int inversedDigit = position;
            int inversedPosition = originalDigit;
            result += inversedDigit * (int) Math.pow(10, inversedPosition - 1);
            number /= 10;
            position++;
        }
        return result;
    }
}
