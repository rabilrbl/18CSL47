/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package rbl.hamiltonian;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rabil
 */
public class Hamiltonian {

    final int adj[][], x[], n;
    static boolean flag = false;

    public Hamiltonian() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix");

        adj = new int[n][n];
        for (int[] items : adj) {
            Arrays.setAll(items, i -> sc.nextInt());
        }

        x = new int[n];
        Arrays.fill(x, -1);
        x[0] = 0;
    }

    public void nextValue(int k) {
        int i = 0;
        while (true) {
            x[k] += 1;

            if (x[k] == n) {
                x[k] = -1;
                return;
            }

            if (adj[x[k - 1]][x[k]] == 1) {
                for (i = 0; i < k; i++) {
                    if (x[i] == x[k]) {
                        break;
                    }
                }
            }

            if (i == k) {
                if (k < n-1 || k==n-1 && adj[x[n - 1]][0] == 1) {
                    return;
                }
            }
        }
    }
    
    public void getHCycle(int k){
        while(true){
            nextValue(k);
            if(x[k] == -1)
                return;
            if(k == n-1){
                System.out.println("solution");
                flag = true;
                for(int i: x)
                    System.out.print((i+1)+"->");
                System.out.println("1");
            } else {
                getHCycle(k+1);
            }
        }
    }
    
    public static void main(String[] args) {
        Hamiltonian h = new Hamiltonian();
        h.getHCycle(1);
        if(!flag)
            System.out.println("no solution");
    }
    
    

}
