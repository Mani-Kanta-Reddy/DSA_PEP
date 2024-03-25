package array;

import java.util.Scanner;

public class BarChart
{
    /*
    Input : 5
            3
            1
            0
            7
            5

    Output :
    			*
    			*
    			*	*
    			*	*
    *			*	*
    *			*	*
    *	*		*	*

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
//        printBarChart(arr);
        printBarChartSmart(arr);
    }
    public static void printBarChartSmart(int[] arr) {
        // find the max value from arr (that is the max height of the chart)
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int buildings = arr.length;
        for(int floor = max; floor >= 1; floor--) {
            for(int building = 0; building < buildings; building++) {
                if(arr[building] >= floor) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    public static void printBarChart(int[] arr) {
        //no.of columns
        int cols = arr.length;
        //max row value
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int rows = max;
        boolean[][] chart = new boolean[rows][cols];
        for(int col = 0; col < cols; col++) {
            int times = arr[col];
            int row = rows - 1;

            while(times-- != 0) {
                chart[row--][col] = true;
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(chart[i][j]) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
