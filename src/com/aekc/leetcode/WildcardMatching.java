package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-2 下午3:50
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if(p.length() > s.length() && !p.contains("?")) {
            return false;
        }
        int k = 0;
        int temp = -1;
        int temp2 = -1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(k == p.length()) {
                return false;
            }
            if(p.charAt(k) == '*') {
                if(k + 1 < p.length()) {
                    if(p.charAt(k + 1) == s.charAt(i)) {
                        if(k == 0) {
                            k++;
                            i--;
                            continue;
                        }
                        temp = k + 1;
                        temp2 = i + 1;
                        k = k + 2;
                    }
                }
                stringBuilder.append(s.charAt(i));
            } else if(p.charAt(k) == '?') {
                stringBuilder.append(s.charAt(i));
                k++;
            } else if(p.charAt(k) == s.charAt(i)) {
                stringBuilder.append(s.charAt(i));
                k++;
            } else {
                if(temp != -1) {
                    k = temp - 1;
                    i = temp2 - 1;
                    temp = temp2 = -1;
                    continue;
                }
                return false;
            }
        }

        return stringBuilder.toString().equals(s);
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("mississippi", "m??*ss*?i*pi"));
    }
}
