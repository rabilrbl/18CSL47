/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package rbl.quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rabil
 */
public class QuickSort {

    int partition(int[] a, int low, int high) {
        int temp;
        int pivot = a[low];
        int i = low + 1;
        int j = high;

        while (low < high) {
            while (a[i] <= pivot && i < high) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }

            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                temp = a[low];
                a[low] = a[j];
                a[j] = temp;
                return j;
            }
        }
        return j;
    }

    void sort(int[] a, int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            sort(a, low, s - 1);
            sort(a, s + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of elements");
        int elemCount = sc.nextInt();

        Random rand = new Random();

        int[] arr = new int[elemCount];

        Arrays.setAll(arr, i -> rand.nextInt(10000));

        System.out.println("Array before sorting");
        System.out.println(Arrays.toString(arr));

        QuickSort qs = new QuickSort();

        long startTime = System.nanoTime();
        qs.sort(arr, 0, elemCount - 1);
        long totalTime = System.nanoTime()- startTime;

        System.out.println("Array after sorting");
        System.out.println(Arrays.toString(arr));

        System.out.println("Total Time elapsed: " + totalTime + "ns");

    }
}
