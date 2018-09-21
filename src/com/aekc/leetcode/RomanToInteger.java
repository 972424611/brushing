package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-21 下午4:04
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] a = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int sum = 0;
        for(int i = 0; i < str.length; i++) {
            while(s.startsWith(str[i])) {
                s = s.replaceFirst(str[i], "");
                sum = sum + a[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
