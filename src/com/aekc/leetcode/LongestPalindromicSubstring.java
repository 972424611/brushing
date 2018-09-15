package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-12 下午7:18
 */
public class LongestPalindromicSubstring {

    private String p = "";

    public boolean deal(String s) {

        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if(s.length() > p.length() && !deal(s)) {
            String q = s;
            s = q.substring(0, q.length() - 1);
            longestPalindrome(s);
            s = q.substring(1, s.length() + 1);
            longestPalindrome(s);
        } else {
            if(p.length() < s.length()) {
                p = s;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String s = "babaddtattarrattatddetartrateedredividerbpppppp";
        //longestPalindromicSubstring.sed = new String[]
        System.out.println(s.hashCode());
        s = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
