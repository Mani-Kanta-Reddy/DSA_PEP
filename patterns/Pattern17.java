package patterns;

import java.util.Scanner;

public class Pattern17
{
    /*
    Input : 5
    Output :
    		*
    		*	*
    *	*	*	*	*
    		*	*
    		*

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n) {
        int vals = 1;
        for(int i = 1; i <= n; i++) {
            // if row is mid just print all stars
            if(i == n / 2 + 1) {
                for(int j = 1; j <= n; j++) {
                    System.out.print("*\t");
                }
            }
            // if row is not mid we print tabs followed by stars
            else {
                for(int j = 1; j <= n / 2; j++) {
                    System.out.print("\t");
                }
                for(int j = 1; j <= vals; j++) {
                    System.out.print("*\t");
                }
            }
            if(i <= n / 2) {
                vals++;
            } else {
                vals--;
            }
            System.out.println();
        }
    }
}
