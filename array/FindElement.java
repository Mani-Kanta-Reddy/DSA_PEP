package array;

import java.util.Scanner;

public class FindElement
{
    /*
    Input : 6 (n)
            23 (elements)
            77
            8
            93
            42
            97
            97 (target)
    Output : 5
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(findElementPosition(arr, target));
    }
    public static int findElementPosition(int[] arr, int target) {
        int pos = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
