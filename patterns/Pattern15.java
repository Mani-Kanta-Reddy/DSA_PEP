package patterns;

import java.util.Scanner;

public class Pattern15
{
    /*
    Input : 5
    Output :
      1
     232
    34543
     232
      1

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        int os = n / 2;
        int elementsInARow = 1;
        int row = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= os; j++) {
                System.out.print(" ");
            }
            int val = row;
            for(int j = 1; j <= elementsInARow; j++) {
                System.out.print(val);
                if(j <= elementsInARow / 2)  val++;
                else val--;
            }
            if(i <= n / 2)  {
                os--;
                elementsInARow += 2;
                row++;
            } else {
                os++;
                elementsInARow -= 2;
                row--;
            }
            System.out.println();
        }
    }
}
