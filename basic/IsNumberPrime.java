package basic;

import java.util.Scanner;

public class IsNumberPrime
{
    /*
    Input : 23
    Output : true
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        boolean isPrime = isPrime(number);
        System.out.println(isPrime);
    }

    private static boolean isPrime(int number)
    {
        //special case 1 is neither a prime nor composite, so we return false
        if(number == 1) return false;

        //Find at least one factor exists b/w 2 and root(n), if exists then it's not prime
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
