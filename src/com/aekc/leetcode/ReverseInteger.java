package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-16 上午10:13
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            flag = false;
        }
        String s = String.valueOf(x);
        if (!flag) {
            s = "-" + new StringBuilder(s.substring(1)).reverse().toString();
            String min = String.valueOf(Integer.MIN_VALUE);
            if (s.length() == min.length()) {
                return s.compareTo(min) > 0 ? 0 : Integer.parseInt(s);
            }
        } else {
            s = new StringBuilder(s).reverse().toString();
            String max = String.valueOf(Integer.MAX_VALUE);
            if (s.length() == max.length()) {
                return s.compareTo(max) > 0 ? 0 : Integer.parseInt(s);
            }
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-1999999999));
    }
}
