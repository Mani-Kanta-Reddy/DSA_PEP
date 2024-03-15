package patterns;

import java.util.Scanner;

public class Pattern10
{
    /*
    Input : 5
    Output :
       *
      * *
     *   *
    *     *
     *   *
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
        int outerSpaces = n / 2;
        int innerSpaces = -1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= outerSpaces; j++) {
                System.out.print(" ");
            }

            System.out.print("*");

            for(int j = 1; j <= innerSpaces; j++) {
                System.out.print(" ");
            }

            if(i > 1 && i < n) {
                System.out.print("*");
            }

            if(i <= n / 2) {
                outerSpaces--;
                innerSpaces += 2;
            } else {
                outerSpaces++;
                innerSpaces -= 2;
            }
            System.out.println();
        }
    }
}
