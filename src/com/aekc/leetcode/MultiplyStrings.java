package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-2 下午2:18
 */
public class MultiplyStrings {

    public String addition(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        if(num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char carry = ' ';
        for(int i = 0; i < num1.length(); i++) {
            int k;
            if(i < num2.length()) {
                k = Integer.valueOf(num1.charAt(i) + "") + Integer.valueOf(num2.charAt(i) + "");
            } else {
                k = Integer.valueOf(num1.charAt(i) + "");
            }
            if(carry != ' ') {
                k += Integer.valueOf(carry + "");
                carry = ' ';
            }
            if(k >= 10) {
                if(i == num1.length() - 1) {
                    stringBuilder.insert(0, String.valueOf(k));
                    break;
                }
                carry =  String.valueOf(k).charAt(0);
                stringBuilder.insert(0, String.valueOf(k).charAt(1));
            } else {
                stringBuilder.insert(0, String.valueOf(k).charAt(0));
            }
        }
        return stringBuilder.toString();
    }

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".endsWith(num2)) {
            return "0";
        }
        if(num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String sum = "";
        StringBuilder o = new StringBuilder();
        for(int i = num1.length() - 1; i >= 0; i--) {
            char carry = ' ';
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = num2.length() - 1; j >= 0; j--) {
                int k = Integer.valueOf(num1.charAt(i) + "") * Integer.valueOf(num2.charAt(j) + "");
                if(carry != ' ') {
                    k += Integer.valueOf(carry + "");
                    carry = ' ';
                }
                if(k >= 10) {
                    if(j == 0) {
                        stringBuilder.insert(0, String.valueOf(k));
                        break;
                    }
                    carry =  String.valueOf(k).charAt(0);
                    stringBuilder.insert(0, String.valueOf(k).charAt(1));
                } else {
                    stringBuilder.insert(0, String.valueOf(k).charAt(0));
                }
            }
            sum = addition(sum, stringBuilder.toString() + o.toString());
            o.append("0");
        }
        return sum;
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("0", "456"));
    }
}
