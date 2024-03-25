package numbersystem;

import java.util.Scanner;

public class AnyBaseToDecimal
{
    /*
    Input : 98
            8
    Output : 80
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int base = in.nextInt();
        System.out.println(convertAnyBaseToDecimal(number, base));
    }
    public static int convertAnyBaseToDecimal(int number, int base) {
        int power = 1; // base ^ 0
        int result = 0;
        while(number > 0) {
            int digit = number % 10;
            number /= 10;
            result += digit * power;
            power *= base;
        }
        return result;
    }
}
