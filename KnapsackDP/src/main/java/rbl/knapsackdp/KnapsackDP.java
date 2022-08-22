/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package rbl.knapsackdp;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rabil
 */
public class KnapsackDP {

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static void knapSack(int W, int wt[], int val[], int n) {
        int i, j;
        int K[][] = new int[n + 1][W + 1];

        K[0][0] = 0;
        
        // Build table K[][] in bottom up manner
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= W; j++) {
                if(j<wt[i])
                    K[i][j] = K[i-1][j];
                else
                    K[i][j] = Math.max(val[i]+ K[i - 1][j - wt[i]], K[i - 1][j]);
            }
        }
        
        System.out.println("Optimal value = "+K[n][W]);
        
        if(K[n][W] == 0)
            System.out.println("Optimal susbset doesn't exist");
        else {
            System.out.println("Optimal subset");
            for (i = n; i>0 && W>0; i--) {
                if(K[i][W] != K[i-1][W]){
                    System.out.print(i+" ");
                    W=W-wt[i];
                }
            }
        }
    }

    // Driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of items");
        int n = sc.nextInt();
        
        int[] wt = new int[n+1];
        System.out.println("Enter weight of 4 items");
        for (int i = 1; i <= n; i++) {
            wt[i] = sc.nextInt();
        }
        
        int[] val = new int[n+1];
        System.out.println("Enter profile/value for items");
        for (int i = 1; i <= n; i++) {
            val[i] = sc.nextInt();
        }
        
        System.out.println("Enter knapsack capacity");
        int W = sc.nextInt();
        
        knapSack(W, wt, val, n);
    }
}
