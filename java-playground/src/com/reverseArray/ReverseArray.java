/**
 * Created by bharghava on 1/6/17.
 * http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */

package com.reverseArray;

public class ReverseArray {
    public static void reverse(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int temp;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start+1, end-1);
    }

    public static void printArray(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        printArray(arr);
        reverse(arr, 0, arr.length-1);
        System.out.println("\nAfter reversed: ");
        printArray(arr);
    }
}
