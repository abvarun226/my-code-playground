package com.Karatsuba;

/**
 * Created by bharghava on 3/6/17.
 * https://www.coursera.org/learn/algorithms-divide-conquer/lecture/wKEYL/karatsuba-multiplication
 */

public class Multiply {

    public static int numDigits(long x) {
        int count = 0;
        while (x > 0) {
            x = x / 10;
            count++;
        }
        return count;
    }

    public static long multiply(long x, long y) {
        int N1 = numDigits(x);
        int N2 = numDigits(y);
        int N = Math.max(N1, N2);

        if (N < 10) {
            return x * y;
        }

        N = (N / 2) + (N % 2);
        long m = (long) Math.pow(10, N);
        long m2 = (long) Math.pow(10, 2 * N);

        long a = x / m;
        long b = x - (a * m);
        long c = y / m;
        long d = y - (c * m);

        long r1 = multiply(a, c);
        long r2 = multiply(a + b, c + d);
        long r3 = multiply(b, d);

        return m2 * r1 + m * (r3 - r2 - r1) + r3;
    }

    public static void main(String[] args) {
        long x = 5678;
        long y = 1234;

        System.out.println("\nExpected Result = " + (x * y));
        System.out.println("Computed Result = " + multiply(x, y));
    }

}