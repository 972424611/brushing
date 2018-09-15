package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-13 下午5:14
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(s.length() < 2 || numRows < 2 || s.length() <= numRows) {
            return s;
        }
        int start = 0;
        int end = numRows;
        int length = s.length() - 1 / numRows + 1;
        char[][] c = new char[length][numRows];
        int k = 0;
        for (int i = 0; i < length; i++) {
            String temp = s.substring(start + 1, end);
            if (k % 2 != 0) {
                temp = new StringBuilder(temp).reverse().toString();
                while(temp.length() < numRows - 1) {
                    temp = " " + temp;
                }
            } else {
                temp = s.substring(start + 1, end);
            }
            int p = numRows - 1;
            if (temp.length() < p) {
                p = temp.length();
            }
            for (int j = 0; j < p; j++) {
                if (j == 0) {
                    c[i][j] = ' ';
                }
                if (k % 2 != 0) {
                    c[i][j] = temp.charAt(j);
                } else {
                    c[i][j + 1] = temp.charAt(j);
                }
            }
            k++;
            start = end - 1;
            end = end + numRows - 1;
            if (end >= s.length()) {
                end = s.length();
            }
        }
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < numRows; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < length; j++) {
                if(c[j][i] != ' ' && c[j][i] != '\u0000') {
                    stringBuilder.append(c[j][i]);
                }

            }
        }
        return s.charAt(0) + stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String s = zigZagConversion.convert("ABCD", 3);
        System.out.println(s);
    }
}
