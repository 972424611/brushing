package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-17 下午3:19
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int start = 0;
        int max = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                return s.length() - i - 1;
            } else if(i == 0) {
                return s.length();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("aaa"));
    }
}
