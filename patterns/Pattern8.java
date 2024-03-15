package patterns;

import java.util.Scanner;

public class Pattern8
{
    /*
    Input : 5
    Output :
        *
       *
      *
     *
    *

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        printPattern(n);
        printPatternTrick(n);
    }

    public static void printPattern(int n) {
        for(int i = 1; i <= n; i++) {
            int spaces = n - i;
            //spaces
            for(int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
    }
    // Indices of elements on right diagonal has this property that sum of the i, j th indices = n + 1 (rows, and columns starts with 1)
    public static void printPatternTrick(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i + j == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
