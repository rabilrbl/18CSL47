/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package rbl.prims;

/**
 *
 * @author rabil
 */
// Prim's Algorithm in Java

import java.util.Arrays;
import java.util.Scanner;

class Prims {

  public void Prim(int[][] cost, int n) {

    int max = 99;

    int count; // number of edge

    // create a array to track selected vertex
    // selected will become true otherwise false
    boolean[] selected = new boolean[n];
    int minCost = 0;

    // set selected false initially
    Arrays.fill(selected, false);

    // set number of edge to 0
    count = 0;

    // the number of egde in minimum spanning tree will be
    // always less than (V -1), where V is number of vertices in
    // graph

    // choose 0th vertex and make it true
    selected[0] = true;

    // print for edge and weight
    System.out.println("Edge : Weight");

    while (count < n - 1) {
      // For every vertex in the set S, find the all adjacent vertices
      // , calculate the distance from the vertex selected at step 1.
      // if the vertex is already in the set S, discard it otherwise
      // choose another vertex nearest to selected vertex at step 1.

      int min = max;
      int x = 0; // row number
      int y = 0; // col number

      for (int i = 0; i < n; i++) {
        if (selected[i] == true) {
          for (int j = 0; j < n; j++) {
            // not in selected and there is an edge
            if (!selected[j] && cost[i][j] != 0) {
              if (min > cost[i][j]) {
                min = cost[i][j];
                x = i;
                y = j;
              }
            }
          }
        }
      }
      System.out.println(x + " - " + y + " :  " + cost[x][y]);
      minCost += min;
      selected[y] = true;
      count++;
    }
      System.out.println("min Cost is "+minCost);
  }

  public static void main(String[] args) {
    Prims g = new Prims();

    // number of vertices in grapj
    int V = 6;

    // create a 2d array of size 5x5
    // for adjacency matrix to represent graph
    int[][] G = new int[V][V];
      Scanner sc = new Scanner(System.in);
    for(int i=0;i<V;i++)
        for(int j=0;j<V;j++)
            G[i][j] = sc.nextInt();
    int count1;
    for(int i=0;i<V;i++){
        count1 = 0;
        for(int j=0;j<V;j++){
            if(G[i][j] == 99)
                count1++;
        }
        if(count1 == V-1){
            System.out.println("Span doesn't exist");
            System.exit(0);
        }
    }

    g.Prim(G, V);
  }
}
