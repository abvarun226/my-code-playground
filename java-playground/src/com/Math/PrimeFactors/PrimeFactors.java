package com.Math.PrimeFactors;

/**
 * Created by bharghava on 22/6/17.
 */
public class PrimeFactors {
    static void primeFactors(int n) {
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // Now, n will be odd
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // Finally, when n is prime and greater than 2
        if (n > 2) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n = 315;
        primeFactors(n);
    }
}