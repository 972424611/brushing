package com.aekc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Twilight
 * @date 18-9-12 下午7:18
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length() <= 0) {
            return "";
        }
        char[] c = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        int p = 0;
        for(int i = 0; i < c.length; i++) {
            if(map.containsKey(String.valueOf(c[i]))) {
                Integer k = map.get(String.valueOf(c[i]));
                int sum = i - k;
                if(max < sum) {
                    max = sum;
                    p = i;
                }
            } else {
                map.put(String.valueOf(c[i]), i);
            }
        }
        return s.substring(p - max, p + 1);
    }

    public static void main(String[] args) {
        String s = new LongestPalindromicSubstring().longestPalindrome("bbb");
        System.out.println(s);
    }
}
