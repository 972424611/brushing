package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-21 下午3:40
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        while(num >= 1000 || num >= 900) {
            if(num < 1000) {
                s.append("CM");
                num = num - 900;
                break;
            }
            s.append("M");
            num = num - 1000;
        }
        while(num >= 500 || num >= 400) {
            if(num < 500) {
                s.append("CD");
                num = num - 400;
                break;
            }
            s.append("D");
            num = num - 500;
        }
        while(num >= 100 || num >= 90) {
            if(num < 100) {
                s.append("XC");
                num = num - 90;
                break;
            }
            s.append("C");
            num = num - 100;
        }
        while(num >= 50 || num >= 40) {
            if(num < 50) {
                s.append("XL");
                num = num - 40;
                break;
            }
            s.append("L");
            num = num - 50;
        }
        while(num >= 10 || num >= 9) {
            if(num < 10) {
                s.append("IX");
                num = num - 9;
                break;
            }
            s.append("X");
            num = num - 10;
        }
        while(num >= 5 || num >= 4) {
            if(num < 5) {
                s.append("IV");
                num = num - 4;
                break;
            }
            s.append("V");
            num = num - 5;
        }
        while(num >= 1) {
            s.append("I");
            num = num - 1;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(9));
    }
}
