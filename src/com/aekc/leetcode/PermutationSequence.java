package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twilight
 * @date 18-10-17 下午7:27
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2; i <= n; i++) {
            sum = sum * i;
            list.add(i);
        }
        boolean[] flag = new boolean[n];
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int p = sum / n;
            int c;
            if (k % p != 0) {
                c = k / p + 1;
            } else {
                c = k / p;
            }
            sum = sum / n--;
            while (k > p) {
                k = k - p;
            }
            if (c == 0) {
                c = 1;
            }
            stringBuilder.append(list.get(c - 1));
            list.remove(c - 1);
        } while (n != 0);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3, 2));
    }
}
