package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-18 下午9:04
 */
public class StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        String temp2 = "1234567890";
        String temp = "-+";
        String start = str.substring(0, 1);
        if (!temp.contains(start) && !temp2.contains(start)) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] c = str.toCharArray();
        boolean flag = false;
        int sum = 0;
        for (char aC : c) {
            if (flag && !temp2.contains(aC + "")) {
                break;
            }
            if (!flag && temp.contains(aC + "")) {
                if (++sum > 1) {
                    return 0;
                }
                stringBuilder.replace(0, 1, String.valueOf(aC));
                continue;
            }
            if (aC == '0') {
                stringBuilder.append(aC);
                flag = true;
                continue;
            }
            if (temp2.contains(aC + "")) {
                stringBuilder.append(aC);
                flag = true;
            } else {
                break;
            }
        }
        if (!flag) {
            return 0;
        }
        str = stringBuilder.toString().trim();
        if (str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.startsWith("-")) {
            while (str.charAt(1) == '0' && str.length() > 2) {
                str = str.charAt(0) + str.substring(2);
            }
        } else {
            while (str.charAt(0) == '0' && str.length() > 1) {
                str = str.substring(1);
            }
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        if (str.charAt(0) == min.charAt(0)) {
            if (str.length() == min.length()) {
                return str.compareTo(min) > 0 ? Integer.MIN_VALUE : Integer.parseInt(str);
            } else if (str.length() > min.length()) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt(str);
            }
        } else {
            if (str.length() == max.length()) {
                return str.compareTo(max) > 0 ? Integer.MAX_VALUE : Integer.parseInt(str);
            } else if (str.length() > max.length()) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.parseInt(str);
            }
        }
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("    +1146905820n1"));
    }
}
