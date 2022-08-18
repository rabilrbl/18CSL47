/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package rbl.kruskal;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rabil
 */
class Kruskal {

    static int size;
    int[] parent = new int[size+1];

    int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    void union(int i, int j) {
        if (i < j) {
            parent[i] = j;
        } else {
            parent[j] = i;
        }
    }

    void kruskal(int[][] cost) {
        int[][] minTree = new int[size + 1][2];
        int minCost = 0, count = 0;
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
        }
        while (count < size) {
            int min = 99, a = 0, b = 0;
            for(int i=1;i<=size;i++){
                for(int j=1;j<=size;j++){
                    if(cost[i][j] < min && cost[i][j] != 0){
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            if(min == 99)
                break;
            int i = find(a);
            int j = find(b);
            if(i != j){
                minTree[count][0] = i;
                minTree[count][1] = j;
                minCost += min;
                count++;
                union(i,j);
            }
            cost[a][b] = cost[b][a] = 99;
        }
        if(count == size-1){
            System.out.println("Cost of spanning tree: "+minCost);
            System.out.println("Edges of spanning tree");
            for(int i=0;i<=size-2;i++)
                System.out.println(minTree[i][0] + ", "+ minTree[i][1]);
        } else {
            System.out.println("Spanning tree doesn't exist");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of nodes: ");
        size = sc.nextInt();
        int[][] cost = new int[size+1][size+1];
        System.out.println("Enter cost matrix");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        Kruskal k = new Kruskal();
        k.kruskal(cost);
    }
}
