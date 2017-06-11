package com.MissingNum;

/**
 * Created by bharghava on 1/6/17.
 * http://www.geeksforgeeks.org/find-the-missing-number/
 */

public class MissingNum {
    public static int findNum(int[] arr) {
        int x1 = arr[0];
        int y1 = 1;

        for(int i=1; i<arr.length; i++) {
            x1 = x1 ^ arr[i];
        }
        for(int i=2; i<=arr.length+1; i++) {
            y1 = y1 ^ i;
        }
        return x1^y1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 6, 7, 8};
        System.out.println("\nMissing Number is: " + findNum(arr));
    }
}
