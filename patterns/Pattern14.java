package patterns;

import java.util.Scanner;

public class Pattern14
{
    /*
    Input : 16
    Output :
    16 * 1 = 16
    16 * 2 = 32
    16 * 3 = 48
    16 * 4 = 64
    16 * 5 = 80
    16 * 6 = 96
    16 * 7 = 112
    16 * 8 = 128
    16 * 9 = 144
    16 * 10 = 160
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
