package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-18 下午8:50
 */
public class FibonacciSequence {

    private long[] a;

    public long f(int n) {
        if (n <= 2) {
            return 1;
        }
        if (a[n] == 0) {
            long k = f(n - 1) + f( n - 2);
            a[n] = k;
            return k;
        }
        return a[n];
    }

    public static void main(String[] args) {
        int n = 50000;
        long start = System.currentTimeMillis();
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        fibonacciSequence.a = new long[n + 1];
        long end = System.currentTimeMillis();
        System.out.println(fibonacciSequence.f(n) + "-" + (end - start));

    }
}
