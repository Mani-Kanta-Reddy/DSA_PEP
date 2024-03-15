package basic;

import java.util.Scanner;

public class DigitsOfANumber
{
    /*
    Input : 123
    Output : 3
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int noOfDigits = 0;
        while(number != 0) {
            noOfDigits++;
            number /= 10;
        }
        System.out.println(noOfDigits);
    }
}
