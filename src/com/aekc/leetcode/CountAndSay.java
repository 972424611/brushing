package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-1 下午2:11
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String start = "1";
        for(int i = 2; i <= n; i++) {
            String str = "";
            int sum = 1;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 1; j < start.length(); j++) {
                if(start.charAt(j) != start.charAt(j - 1)) {
                    str = str.concat(sum + "" + start.charAt(j - 1));
                    stringBuilder.append(sum);
                    stringBuilder.append(start.charAt(j - 1));
                    sum = 0;
                }
                sum++;
            }
            stringBuilder.append(sum);
            stringBuilder.append(start.charAt(start.length() - 1));
            start = stringBuilder.toString();
        }
        return start;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(50));
    }
}
