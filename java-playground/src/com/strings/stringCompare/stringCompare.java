package com.strings.stringCompare;

/**
 * Created by bharghava on 27/6/17.
 * https://www.hackerrank.com/challenges/java-string-compare
 */

import java.util.Scanner;

public class stringCompare {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        for(int i=1; i + k <= s.length(); i++) {
            String temp = s.substring(i, i + k);
            if(smallest.compareTo(temp) > 0) {
                smallest = temp;
            }
            if(largest.compareTo(temp) < 0) {
                largest = temp;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
