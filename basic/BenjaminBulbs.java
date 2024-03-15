package basic;

import java.util.Scanner;

public class BenjaminBulbs
{
    /*
    Input : 100 (bulbs)
    Output : 1 3 16 25 36 49 64 81 100
       1 2 3 4 5 6 7 8 9 10 11 12 13 ... 20
     1 *
     2 * *
     3 *   *
     4 * *   *
     5 *       *
     6 * * *     *
     7 *           *
     .
     .
     .
    20 * *   * *                           *

    If off initially then bulb
    - 1 flips and becomes on
    - 2 flips off
    generally
    - odd flips makes bulb on
    - even flips makes bulb off

    Hence, problem breaks down to figure out the numbers that have odd number of factors and interestingly
    - only perfect square number can only have odd number of factors (2n + 1)

    eg.,
    24 -> 1 * 24, 2 * 12, 3 * 8, 4 * 6
          6 * 4, 8 * 3, 12 * 2, 24 * 1    (2n even)
    36 -> 1 * 36, 2 * 18, 3 * 12, 4 * 9, 6 * 6
          9 * 4, 12 * 3, 18 * 2, 36 * 1   (2n + 1 odd)
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int bulbs = in.nextInt();
        for(int i = 1; i * i <= bulbs; i++) {
            System.out.printf("%d ", i * i);
        }
    }

}
