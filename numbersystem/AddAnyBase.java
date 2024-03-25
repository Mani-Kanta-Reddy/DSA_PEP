package numbersystem;

import java.util.Scanner;

public class AddAnyBase
{
    /*
    Input : 98 (n1)
            87 (n2)
            8  (n1 & n2s base)
    Output : 227 (addition result with same base)
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int base = in.nextInt();
        System.out.println(add(n1, n2, base));
    }
    public static int add(int n1, int n2, int base) {
        int c = 0;
        int power = 1;  // 10 ^ 0
        int result = 0;
        while(n1 > 0 || n2 > 0 || c > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;
            int res = d1 + d2 + c;
            int digit = res % base;
            c = res / base;
            result += digit * power;
            power *= 10;
        }
        return result;
    }
}
