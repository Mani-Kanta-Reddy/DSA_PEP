package basic;

import java.util.Scanner;

public class FibonaccisTillN
{
    /*
    Input : 8
    Output: 0 1 1 2 3 5 8 13
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printFibs(n);
    }

    public static void printFibs(int n) {
        int a = 0;
        int b = 1;
        for(int i = 1; i <= n; i++) {
            System.out.printf("%d ", a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
