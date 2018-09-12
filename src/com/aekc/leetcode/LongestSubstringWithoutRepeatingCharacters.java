package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Twilight
 * @date 18-9-11 下午8:22
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        char[] a = s.toCharArray();
        int sum = 0;
        int max = -1;
        for(int i = 0; i < a.length; i++) {
            String o = String.valueOf(a[i]);
            if(map.containsKey(o)) {
                if(max < sum) {
                    max = sum;
                }
                sum = 0;
                i = map.get(o);
                map.clear();
                continue;
            }
            map.put(o, i);
            sum++;
        }
        if(max < sum) {
            max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int max = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
        System.out.println(max);
    }
}
