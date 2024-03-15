package patterns;

import java.util.Scanner;

public class Pattern3
{
    /*
    Input : 7
    Output :
          *
         **
        ***
       ****
      *****
     ******
    *******

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
