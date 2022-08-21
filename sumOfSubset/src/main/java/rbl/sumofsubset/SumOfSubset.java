/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package rbl.sumofsubset;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author rabil
 */
public class SumOfSubset {

    int set[];
  int sum;
  
  Stack<Integer> solutionSet;
  boolean hasSolution;
  
  SumOfSubset(int set[], int sum){
      this.set = set;
      this.sum = sum;
      this.solutionSet = new Stack<>();
      hasSolution = false;
  }
  
  public void solve(int s, int idx){   
    //return false if s value exceed sum
    if(s>sum)
        return;
 
    //check if stack has the right subsets of numbers
    if(s==sum){
        hasSolution = true;
 
        //display stack contents
        displaySolutionSet();
 
        //Though found a solution but deliberately returning to find more
        return;
    }
        
    for(int i=idx; i<set.length; i++){
        //Adding element to the stack
        solutionSet.push(set[i]);
 
        //add set[i] to the 's' and recusively start from next number
        solve(s+set[i],i+1);
 
        //Removing element from stack i.e Backtracking
        solutionSet.pop();
    }

  }
  
  //Function to display stack content
  private void displaySolutionSet(){
    for (int item: solutionSet){
      System.out.print(item+" ");
    }
        System.out.println();
  }
   
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of set: ");
        int n = sc.nextInt();
       int set[] = new int[n];
       System.out.println("Enter set elements: ");
       Arrays.setAll(set, i -> sc.nextInt());
       System.out.println("Enter sum to find");
       int sum = sc.nextInt();
       
       System.out.println("Subsets with sum = "+sum);
    
       SumOfSubset ss = new SumOfSubset(set, sum);
       ss.solve(0,0);
	    
       if(ss.hasSolution == false)
	  System.out.print("No Solution");
    }
}
