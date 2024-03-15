package basic;

import java.util.Scanner;

public class PrimeFactorization
{
    /*
    Input : 24
    Output : 2 2 2 3
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        findPrimeFactors(number);
    }
    public static void findPrimeFactors(int number) {
        for(int i = 2; i * i <= number; i++) {
            while(number % i == 0) {
                System.out.printf("%d ", i);
                number /= i;
            }
        }

        /*
        handle case where number prime which can only be divided by itself
        eg.,
        26 we try till 5 b/c root(26) is ~5
        = 2 | 13
        = but since 13 is prime it remains and can only be divided by itself hence this final check
         */
        if (number != 1)
        {
            System.out.println(number);
        }
    }
}
