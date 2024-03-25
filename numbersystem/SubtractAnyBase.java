package numbersystem;

import java.util.Scanner;

public class SubtractAnyBase
{
    /*
    Input : 1212 (n1)
            256  (n2)
            8    (base)
    Note : n1 is always greater than n2
    Output :
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int base = in.nextInt();
        System.out.println(subtract(n1, n2, base));
    }
    public static int subtract(int n1, int n2, int base) {
        int power = 1; // 10 ^ 0
        int result = 0;
        int borrow = 0;

        //while bigger number is greater than 0
        while(n1 > 0) {
            int d1 = n1 % 10;
            n1 /= 10;
            int d2 = n2 % 10;
            n2 /= 10;
            //settle `d1` with borrow first
            d1 = d1 + borrow;  //subtracting borrow from d1 (don't confuse with + here borrow will be coming as negative)
            int d;
            if(d1 - d2 >= 0) {
                borrow = 0;
                d = d1 - d2;
            } else {
                borrow = -1;
                d = d1 + base - d2; // diff is negative, so we borrow from left (add base to d1)
            }
            result += d * power;
            power *= 10;
        }
        return result;
    }
}
