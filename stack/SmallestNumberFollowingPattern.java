package stack;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
    /*
    Input : ddidddid (d - dec, i - inc)
    Note : Input only contains series of either d or i chars
    Output : 321765498
        Note :
        Return smallest non-repeating number that follows above pattern
         d d i d d d i d
        /\/\/\/\/\/\/\/\
        3 2 1 7 6 5 4 9 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        findNumber(pattern);
    }
    private static void findNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(int i = 0; i < pattern.length(); i++) {
            char currCh = pattern.charAt(i);
            if(currCh == 'd') {
                stack.push(num);
                num++;
            }
            // currCh is `i` which is the breaking point
            else {
                stack.push(num);
                num++;

                while(!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
            }
        }
        // for the last char right ele
        stack.push(num);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
