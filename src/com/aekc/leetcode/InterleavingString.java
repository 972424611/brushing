package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 2019-02-21 08:45
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if("".equals(s1)) {
            return s2.equals(s3);
        }
        if("".equals(s2)) {
            return s1.equals(s3);
        }
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()][s2.length()];
        dp[0][0] = true;
        for(int i = 1; i < s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i < s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i));
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    public static void main(String[] args) {

    }

}
