package rbl.hamiltanonian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Hamiltanonian {

    // Function to check if a vertex v
    // can be added at index pos in
    // the Hamiltonian Cycle
    boolean isSafe(int v, int graph[][], ArrayList<Integer> path, int pos) {
        // If the vertex is adjacent to
        // the vertex of the previously
        // added vertex
        if (graph[path.get(pos - 1)][v]
                == 0) {
            return false;
        }

        // If the vertex has already
        // been included in the path
        for (int i = 0; i < pos; i++) {
            if (path.get(i) == v) {
                return false;
            }
        }

        // Both the above conditions are
        // not true, return true
        return true;
    }

    // To check if there exists
    // at least 1 hamiltonian cycle
    boolean hasCycle;

    // Function to find all possible
    // hamiltonian cycles
    void hamCycle(int graph[][]) {
        // Initially value of boolean
        // flag is false
        hasCycle = false;

        // Store the resultant path
        ArrayList<Integer> path
                = new ArrayList<>();
        path.add(0);

        // Keeps the track of the
        // visited vertices
        boolean[] visited
                = new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        visited[0] = true;

        // Function call to find all
        // hamiltonian cycles
        FindHamCycle(graph, 1, path,
                visited);

        if (!hasCycle) {

            // If no Hamiltonian Cycle
            // is possible for the
            // given graph
            System.out.println("No Hamiltonian Cycle possible ");
            return;
        }
    }

    // Recursive function to find all
    // hamiltonian cycles
    void FindHamCycle(int graph[][], int pos, ArrayList<Integer> path, boolean[] visited) {
        // If all vertices are included
        // in Hamiltonian Cycle
        if (pos == graph.length) {

            // If there is an edge
            // from the last vertex to
            // the source vertex
            if (graph[path.get(path.size() - 1)][path.get(0)]!= 0) {

                // Include source vertex
                // into the path and
                // print the path
                path.add(0);
                for (int i = 0;
                        i < path.size(); i++) {
                    System.out.print((path.get(i)+1) + " ");
                }
                System.out.println();

                // Remove the source
                // vertex added
                path.remove(path.size() - 1);

                // Update the hasCycle
                // as true
                hasCycle = true;
            }
            return;
        }

        // Try different vertices
        // as the next vertex
        for (int v = 0;
                v < graph.length; v++) {

            // Check if this vertex can
            // be added to Cycle
            if (isSafe(v, graph, path, pos) && !visited[v]) {

                path.add(v);
                visited[v] = true;

                // Recur to construct
                // rest of the path
                FindHamCycle(
                        graph, pos + 1,
                        path, visited);

                // Remove current vertex
                // from path and process
                // other vertices
                visited[v] = false;
                path.remove(
                        path.size() - 1);
            }
        }
    }

    // Driver Code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter no. of nodes: ");
        int n  = sc.nextInt();
        
        System.out.println("Enter matrix");
        int graph[][] = new int[n][n];
        
        for(int[] arr: graph){
            Arrays.setAll(arr, i -> sc.nextInt());
        }
        
        Hamiltanonian ham = new Hamiltanonian();
        System.out.println("Solutions are,");
        ham.hamCycle(graph);
    }
}
