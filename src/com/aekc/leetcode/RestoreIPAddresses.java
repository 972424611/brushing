package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twilight
 * @date 2019-02-15 16:10
 */
public class RestoreIPAddresses {

    public String s;

    public List<String> list = new ArrayList<>();

    public void dfs(int index, List<String> record) {
        if(record.size() > 4) {
            return;
        }
        if(index == s.length() && record.size() == 4) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < record.size() - 1; i++) {
                stringBuilder.append(record.get(i)).append(".");
            }
            stringBuilder.append(record.get(record.size() - 1));
            list.add(stringBuilder.toString());
        }
        for(int j = 1; j <= 3; j++) {
            if(index + j > s.length()) {
                return;
            }
            String k = s.substring(index, index + j);
            if(j == 3) {
                if(Integer.valueOf(k) > 255) {
                    return;
                }
            }
            if(k.length() > 1 && k.startsWith("0")) {
                return;
            }
            record.add(k);
            dfs(index + j, record);
            record.remove(record.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if(s == null || s == "") {
            return list;
        }
        this.s = s;
        dfs(0, new ArrayList<>());
        return list;
    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        restoreIPAddresses.restoreIpAddresses("010010");
        restoreIPAddresses.list.forEach(System.out::println);
    }
}
