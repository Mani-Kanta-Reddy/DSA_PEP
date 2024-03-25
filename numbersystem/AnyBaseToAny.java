package numbersystem;

import java.util.Scanner;

public class AnyBaseToAny
{
    /*
    Input : 98 (number)
            8  (number is given in this base)
            2  (convert number to this base)
    Output : 1010000
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int decEquivalent = convertAnyBaseToDecimal(number, b1);
        int result = convertDecimalToAnyBase(decEquivalent, b2);
        System.out.println(result);
    }
    public static int convertAnyBaseToDecimal(int number, int b1) {
        int result = 0;
        int power = 1; // base ^ 0
        while(number > 0) {
            int digit = number % 10;
            number /= 10;
            result += digit * power;
            power *= b1;
        }
        return result;
    }
    public static int convertDecimalToAnyBase(int decimal, int b2) {
        int result = 0;
        int power = 1; // 10 ^ 1
        while(decimal > 0) {
            int digit = decimal % b2;
            decimal /= b2;
            result += digit * power;
            power *= 10;
        }
        return result;
    }
}
