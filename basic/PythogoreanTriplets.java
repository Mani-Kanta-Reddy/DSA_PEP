package basic;

import java.util.Scanner;

public class PythogoreanTriplets
{
    /*
    Input : 5 3 4 (three numbers)
    Output : true ( 25 = 9 + 16)
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        System.out.println(arePythogoreanTriplets(n1, n2, n3));
    }

    public static boolean arePythogoreanTriplets(int n1, int n2, int n3) {
        // find the max of three
        int max = n1;
        if(n2 > max) {
            max = n2;
        }
        if(n3 > max) {
            max = n3;
        }
        if(max == n1) {
            return (max * max) == (n2 * n2) + (n3 * n3);
        } else if(max == n2) {
            return (max * max) == (n1 * n1) + (n3 * n3);
        } else {
            return (max * max) == (n1 * n1) + (n2 * n2);
        }
    }
}
