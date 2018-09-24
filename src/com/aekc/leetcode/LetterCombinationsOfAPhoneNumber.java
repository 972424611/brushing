package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    List<String> list = new ArrayList<>();

    Map<String, String> map = new HashMap<>();

    public void deal(String s, String p) {
        String k = "";
        if(p.length() > 0 && p.length() > 1) {
            if(p.length() > 1) {
                k = p.substring(1);
            }
        } else {
            list.add(s);
            return;
        }
        String q = map.get(String.valueOf(p.charAt(0)));
        for(int i = 0; i < q.length(); i++) {
            deal(s + String.valueOf(q.charAt(i)), k);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        deal("", digits);
        list.forEach(System.out::println);
        return list;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        letterCombinationsOfAPhoneNumber.letterCombinations("23");
    }
}
