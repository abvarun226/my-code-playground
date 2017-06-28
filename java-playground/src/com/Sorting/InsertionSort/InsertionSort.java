package com.Sorting.InsertionSort;

/**
 * Created by bharghava on 3/6/17.
 * http://www.geeksforgeeks.org/insertion-sort/
 */

public class InsertionSort {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 15, 16, 5, 10, 11};
        int key, j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
        printArray(arr);
    }
}
