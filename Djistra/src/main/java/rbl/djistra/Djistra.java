/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package rbl.djistra;

/**
 *
 * @author rabil
 */
public class Djistra {
    
    void dji(int n, int[][] cost, int src){
        int[] visit = new int[n+1];
        int[] dist = new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i] = cost[src][i];
            visit[i] = 0;
        }
        visit[src] = 1;
        int a=0, min=99;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<=n;j++)
                if(dist[j] < min && visit[j]!=0){
                    min = dist[j];
                    a = i;
                }
            for(int j=1;j<=n;j++){
                if(dist[j] > dist[a]+cost[a][j])
                    dist[j] = dist[a]+cost[a][j];
            }
        }
        for(int i=1;i<=n;i++){
            if(i!=src)
                System.out.println("Dist  from "+src+" to "+ i + " is "+disr[i]);
        }
    }

    public static void main(String[] args) {
        Djistra d = new Djistra();
        d.dji(5, cost, 1);
    }
}
