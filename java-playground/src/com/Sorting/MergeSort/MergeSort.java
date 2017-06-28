package com.Sorting.MergeSort;

/**
 * Created by bharghava on 5/6/17.
 */

public class MergeSort {
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static void Merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void MergeSort(int[] arr, int l, int r) {
        if (r > l) {
            int m = (l + r) / 2;
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);
            Merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 15, 16, 5, 10, 11};
        printArray(arr);

        int l = 0;
        int r = arr.length - 1;
        MergeSort(arr, l, r);
        System.out.println("\nSorted Array:");
        printArray(arr);
    }
}
