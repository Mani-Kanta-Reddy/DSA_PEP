package patterns;

import java.util.Scanner;

public class Pattern19
{
    /*
    Input : 5
    Output :
    *				*
    *				*
    *		*		*
    *	*		*	*
    *				*

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                //first and last column stars
                if(j == 1 || j == n) {
                    System.out.print("*\t");
                }

                // lower half and either left diagonal or right diagonal -> star
                else if(i > n / 2 && (i == j || i + j == n + 1)) {
                    System.out.print("*\t");
                }
                // otherwise space
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
