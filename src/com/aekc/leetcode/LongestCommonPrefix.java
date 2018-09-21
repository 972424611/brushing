package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-21 下午4:40
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String minStr = "";
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() > minStr.length()) {
                minStr = strs[i];
            }
        }
        int k = 1;
        String p = "";
        for(int i = 0; i < minStr.length(); i++) {
            String s = minStr.substring(0, i + 1);
            for(int j = 0; j < strs.length; j++) {
                if(!strs[j].startsWith(s)) {
                    return p;
                }
            }
            p = s;
        }
        return p;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}