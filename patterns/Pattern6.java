package patterns;

import java.util.Scanner;

public class Pattern6
{
    /*
    Input : 5
    Output :
    *** ***
    **   **
    *     *
    **   **
    *** ***

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        int stars = n / 2 + 1;
        int spaces = 1;

        for(int i = 1; i <= n; i++) {
            //stars
            for(int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            //spaces
            for(int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            //stars
            for(int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            if(i <= n / 2) {
                stars--;
                spaces += 2;
            } else {
                stars++;
                spaces -= 2;
            }
            System.out.println();
        }
    }
}
