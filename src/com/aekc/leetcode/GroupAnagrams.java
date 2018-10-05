package com.aekc.leetcode;

import java.util.*;

/**
 * @author Twilight
 * @date 18-10-5 下午7:03
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String s = String.valueOf(a);
            if (map.get(s) == null) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> list : lists) {
            for(String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();

        }
    }
}
