package com.DivideAndConquer.MaxSubArray;

/**
 * Created by bharghava on 21/6/17.
 */

class MaxSubArray1 {
    public int[] FindMaxSubArray(int[] A) {
        int size = A.length;
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        int start = 0, end = 0, s = 0;
        for(int i = 0; i < size; i++) {
            maxEndingHere += A[i];
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i + 1;
            }
        }
        return new int[] {start, end, maxSoFar};
    }
}

public class MaxSubArray {
    public int[] FindMaxCrossingSubArray(int[] A, int low, int mid, int high) {
        int leftSum = 0;
        int sum = 0;
        int maxLeft = 0;
        boolean startFlag = true;
        for(int i=mid; i >= low; i--) {
            sum += A[i];
            if(startFlag) {
                leftSum = sum;
                startFlag = false;
                maxLeft = i;
            } else if(sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = 0;
        sum = 0;
        int maxRight = 0;
        startFlag = true;
        for(int j=mid+1; j<=high; j++) {
            sum += A[j];
            if(startFlag) {
                rightSum = sum;
                startFlag = false;
                maxRight = j;
            } else if(sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new int[] {maxLeft, maxRight, leftSum+rightSum};
    }

    public int[] FindMaxSubArray(int[] A, int low, int high) {
        if(low == high) {  // base case: when array has one element
            return new int[] {low, high, A[low]};
        } else {
            int mid = (low + high)/2;
            int[] temp;
            temp = FindMaxSubArray(A, low, mid);
            int leftLow = temp[0], leftHigh = temp[1], leftSum = temp[2];
            temp = FindMaxSubArray(A, mid+1, high);
            int rightLow = temp[0], rightHigh = temp[1], rightSum = temp[2];
            temp = FindMaxCrossingSubArray(A, low, mid, high);
            int crossLow = temp[0], crossHigh = temp[1], crossSum = temp[2];

            if(leftSum >= rightSum && leftSum >= crossSum) {
                return new int[] {leftLow, leftHigh, leftSum};
            } else if(rightSum >= leftSum && rightSum >= crossSum) {
                return new int[] {rightLow, rightHigh, rightSum};
            } else {
                return new int[] {crossLow, crossHigh, crossSum};
            }
        }
    }

    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4};
        int[] result;

        System.out.println("1) Divide-and-Conquer");
        result = obj.FindMaxSubArray(A, 0, A.length-1);
        for(int i=result[0]; i <= result[1]; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.printf("\nSum = %d\n", result[2]);
        System.out.println("Running Time: O(nlgn)\n\n");

        System.out.println("2) Kadane's Algorithm");
        MaxSubArray1 obj2 = new MaxSubArray1();
        result = obj2.FindMaxSubArray(A);
        for(int i=result[0]; i <= result[1]; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.printf("\nSum = %d\n", result[2]);
        System.out.println("Running Time: O(n)");
    }
}
