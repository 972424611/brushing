package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Twilight
 * @date 18-9-27 下午6:35
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        String p = s;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            p = p.replaceAll(words[i], i + "");
        }
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] flag = new boolean[words.length];
        for(int i = 0; i < p.length(); i++) {
            String q = p.substring(i, words.length);
            //for()
        }
        return list;
    }

    public static void  main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        List<Integer> list = substringWithConcatenationOfAllWords.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
