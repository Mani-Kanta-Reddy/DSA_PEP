package numbersystem;

import java.util.Scanner;

public class DecimalToAnyBase
{
    /*
    Input : 66
            8
    Output : 1172

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int base = in.nextInt();
        System.out.println(convertDecimalToAnyBase(number, base));
    }

    public static int convertDecimalToAnyBase(int number, int base) {
        int power = 1; // 10 ^ 0
        int result = 0;
        while(number > 0) {
            int digit = number % base;
            number /= base;
            result += digit * power;
            power *= 10;
        }
        return result;
    }
}
