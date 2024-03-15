package patterns;

import java.util.Scanner;

public class Pattern2
{
    /*
    Input : 7
    Output :
    * * * * * * *
    * * * * * *
    * * * * *
    * * * *
    * * *
    * *
    *

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        printPattern(n);
    }

    public static void printPattern(int n) {
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
