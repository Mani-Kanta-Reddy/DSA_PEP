package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingIntervals {
    /*
    Input : 6 (n - intervals with startTime & endTime)
            22 28
            1 8
            25 27
            14 19
            27 30
            5 12
    Output : Merge the possible intervals and return them in ascending order of their startTime
            1 12
            14 19
            22 30

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++) {
            String[] interval = sc.nextLine().split("\\s");
            pairs[i] = new Pair(Integer.parseInt(interval[0]), Integer.parseInt(interval[1]));
        }
        mergeIntervals(pairs);
    }

    private static void mergeIntervals(Pair[] pairs) {
        Arrays.sort(pairs);
        Stack<Pair> stack = new Stack<>();
        stack.push(pairs[0]);
        for(int i = 1; i < pairs.length; i++) {
            Pair top = stack.peek();
            Pair curr = pairs[i];
            if(top.endTime < curr.startTime) {
                stack.push(curr);
            } else {
                //intervals can be merged
                top.endTime = Math.max(top.endTime, curr.endTime);
            }
        }
        // print the stack items in reverse-order
        for(Pair item : stack) {
            System.out.println(item.startTime + " " + item.endTime);
        }
    }

    private static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;
        Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // sort the pairs by startTime if startTime same then sort by endTime
        @Override
        public int compareTo(Pair other) {
            if(this.startTime != other.startTime) return this.startTime - other.startTime;
            return this.endTime - other.endTime;
        }
    }
}
