package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-20 下午8:49
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int k = x;
        if(x < 0) {
            return false;
        }
        int sum = 0;
        while(x > 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return sum == k;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(0));
    }
}
