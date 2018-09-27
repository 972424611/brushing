package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-27 下午2:51
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("hello", "0"));
    }
}
