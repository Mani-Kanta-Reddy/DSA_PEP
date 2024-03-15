package patterns;

import java.util.Scanner;

public class Pattern4
{
    /*
    Input : 7
    Output :
    *******
     ******
      *****
       ****
        ***
         **
          *
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n) {
        int spaces = 0;
        int stars = n;
        for(int i = 1; i <= n; i--) {
            //print spaces first
            for(int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            //print stars (5, 4, 3, 2, 1)
            for(int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            spaces++;
            stars--;
            System.out.println();
        }
    }
}
