package patterns;

import java.util.Scanner;

public class Pattern16
{
    /*
    Input : 5
    Output :
    1								1
    1	2						2	1
    1	2	3				3	2	1
    1	2	3	4		4	3	2	1
    1	2	3	4	5	4	3	2	1

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        int enclosingSpaces = 2 * n - 3;
        for(int i = 1; i <= n; i++) {
            int val = 1;
            for(int j = 1; j <= i; j++) {
                System.out.print(val++ + "\t");
            }
            for(int j = 1; j <= enclosingSpaces; j++) {
                System.out.print("\t");
            }
            if(i == n) {
                val--;
                for(int j = 1; j < i; j++) {
                    System.out.print(--val + "\t");
                }
            } else {
                for(int j = 1; j <= i; j++) {
                    System.out.print(--val + "\t");
                }
            }

            enclosingSpaces -= 2;
            System.out.println();
        }
    }
}
