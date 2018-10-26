package com.aekc.leetcode;

import java.util.*;

/**
 * @author Twilight
 * @date 18-10-25 下午4:14
 */
public class MinimumWindowSubstring {

    public String minWindow2(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for(int right = 0; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while(count == t.length()) {
                    if(right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if(map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if(map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("bba", "ab"));
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubstring.minWindow("acbbaca", "aba"));
        System.out.println(minimumWindowSubstring.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }

    public String minWindow(String s, String t) {
        if(t.length() == 1) {
            return s.contains(t) ? t : "";
        }
        if(s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int sum = 0;
        int start = 0, end = 0;
        int x = -1, y = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = false;
            Integer o = map.get(c);
            if(o == null) {
                continue;
            }
            if(o > 0) {
                map.put(c, --o);
                if(x == -1) {
                    x = i;
                } else {
                    list.add(i);
                }
                sum++;
                if(sum == t.length()) {
                    y = i;
                }
                flag = true;
            }

            if(x != -1 && list.size() > 0 && !flag && c == s.charAt(x)) {
                x = list.get(0);
                list.add(i);
                list.remove(0);
            }
            if(sum == t.length()) {
                if((start == 0 && end == 0) || y - x < end - start - 1) {
                    start = x;
                    end = y + 1;
                }
                i = x;
                if(s.length() - i - 1 < t.length()) {
                    break;
                }
                for(int k = 0; k < t.length(); k++) {
                    int j = map.get(t.charAt(k));
                    map.put(t.charAt(k), ++j);
                }
                x = -1;
                sum = 0;
                list = new LinkedList<>();
            }
        }
        return s.substring(start, end);
    }
}
