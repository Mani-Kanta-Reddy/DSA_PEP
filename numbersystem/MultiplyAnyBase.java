package numbersystem;

import java.util.Scanner;

public class MultiplyAnyBase
{
    /*
    Input : 2156 (n1)
            74   (n2)
            8    (base)
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int base = in.nextInt();
        System.out.println(multiply(n1, n2, base));
    }

    public static int multiply(int n1, int n2, int base) {
        int result = 0;
        int power = 1; // 10 ^ 0
        while(n2 > 0) {
            int digit = n2 % 10;
            n2 /= 10;
            int singleDigitProduct = multiplyNumberWithSingleDigit(n1, digit, base);
            result = add(result, singleDigitProduct * power, base);
            power *= 10;
        }
        return result;
    }

    public static int multiplyNumberWithSingleDigit(int number, int digit, int base) {
        int carry = 0;
        int result = 0;
        int power = 1; // 10 ^ 0
        while(number > 0 || carry > 0) {
            int d = number % 10;
            number /= 10;
            int res = digit * d + carry;
            carry = res / base;
            int currRes = res % base;
            result += currRes * power;
            power *= 10;
        }
        return result;
    }

    public static int add(int n1, int n2, int base) {
        int carry = 0;
        int result = 0;
        int power = 1; // 10 ^ 1

        while(n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;
            int res = d1 + carry + d2;
            carry = res / base;
            int d = res % base;
            result += d * power;
            power *= 10;
        }
        return result;
    }
}
