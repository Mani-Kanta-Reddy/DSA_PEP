package basic;

import java.util.Scanner;

public class LCMAndGCD
{
    /*
    Input : 20 34
    Output : 2 340 (gcd lcm)
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        int[] result = findGcdAndLcm(n1, n2);
        System.out.printf("%d %d", result[0], result[1]);
    }

    public static int[] findGcdAndLcm(int n1, int n2) {
        int dividend = n1;
        int divisor = n2;
        while(dividend % divisor != 0) {
            int remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        // n1 * n2 = lcm * gcd
        return new int[] {divisor, (n1 * n2) / divisor};
    }
}
