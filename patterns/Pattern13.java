package patterns;

import java.util.Arrays;
import java.util.Scanner;

public class Pattern13
{
    /*
    Input : 6

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n) {
        for(int i = 0; i < n; i++) {
            int icj = 1;
            for(int j = 0; j <= i; j++) {
                System.out.print(icj + " ");
                int icjp1 = icj * (i - j) / (j + 1);
                icj = icjp1;
            }
            System.out.println();
        }
    }
}
