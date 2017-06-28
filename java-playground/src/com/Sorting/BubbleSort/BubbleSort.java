package com.Sorting.BubbleSort;

/**
 * Created by bharghava on 11/6/17.
 */
public class BubbleSort {
    private int[] arr;

    void setArr(int[] arr) {
        this.arr = arr;
    }

    void printArray() {
        for (int i : arr)
            System.out.printf("%d ", i);
        System.out.println();
    }

    void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        int[] arr = {9, 7, 6, 15, 16, 5, 10, 11};
        obj.setArr(arr);
        obj.printArray();
        System.out.println("After Sorting: ");
        obj.sort();
        obj.printArray();
    }
}
