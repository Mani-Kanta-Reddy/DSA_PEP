package basic;

import java.util.Scanner;

public class PrimesTillN
{
    /*
    Input: 5
    Output : 2 3 5 7 11
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        for(int i = 1; i <= number; i++) {
            if (isPrime(i))
            {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int number) {
        //special case 1 is neither prime nor composite, so we return false
        if(number == 1) return false;

        int factors = 0;
        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0) {
                factors++;
                break;
            }
        }

        return factors == 0;
    }
}
