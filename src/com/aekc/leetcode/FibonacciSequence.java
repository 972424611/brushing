package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-18 下午8:50
 */
public class FibonacciSequence {

    private int[] a;

    public int f(int n) {
        if (n <= 2) {
            return 1;
        }
        if (a[n] == 0) {
            int k = f(n - 1) + f(n - 2);
            a[n] = k;
            return k;
        }
        return a[n];
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        fibonacciSequence.a = new int[101];
        System.out.println(fibonacciSequence.f(40));
    }
}
