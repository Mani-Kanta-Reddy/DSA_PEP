package patterns;

import java.util.Scanner;

public class Pattern5
{
    /*
    Input : 5
    Output :
      *
     ***
    *****
     ***
      *

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n) {
        int stars = 1;
        int spaces = n / 2;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            if(i <= n / 2) {
                spaces--;
                stars += 2;
            } else {
                spaces++;
                stars -= 2;
            }
            System.out.println();
        }
    }
}
