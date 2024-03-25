package stack;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    /*
    Input :
        3
        0 1 1 1
        1 0 1 0
        0 0 0 0
        1 1 1 0

    Output : 2

    Note : matrix indices are persons
    mat[i][j] = 0 denotes that i doesn't follow j
    mat[i][j] = 1 denotes that i follows j

    Celeb : A person is considered to be a celeb if
        1. he is followed by everyone and
        2. he doesn't follow anyone
    Note : if i == j -> mat[i][j] = 0 | makes sense a person can't follow himself
    Thoughtful QAs : Can we have more than one celeb ? Ans : No, b/c if one is already celeb it means he doesn't follow anyone so others can't be celebs
                   : If i is celeb then entire row should be 0 and respective col values should be 1 except for the diagonal
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        isCelebExists(mat, n);
    }
    private static void isCelebExists(int[][] mat, int n) {
        // 1. eliminate persons that can't be celebs, idea is if they are following someone they can't be celeb
        int potentialCeleb = getPotentialCeleb(mat, n);
        // Now verify if he's actually a celeb
        for(int i = 0; i < n; i++) {
            if(i != potentialCeleb) {
                if(mat[potentialCeleb][i] == 1 || mat[i][potentialCeleb] == 0) {
                    System.out.println("NONE");
                    return;
                }
            }
        }
        System.out.println(potentialCeleb);
    }

    private static int getPotentialCeleb(int[][] mat, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            stack.push(i);
        }
        while(stack.size() >= 2) {
            int p1 = stack.pop();
            int p2 = stack.pop();
            if(mat[p1][p2] == 1) {
                stack.push(p2);
            } else {
                stack.push(p1);
            }
        }

        // stack size becomes one
        return stack.pop();
    }
}
