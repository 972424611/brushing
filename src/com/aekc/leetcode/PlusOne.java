package com.aekc.leetcode;

import java.util.Arrays;

/**
 * @author Twilight
 * @date 18-10-21 下午1:08
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for(int i = digits.length - 1; i >= 1; i--) {
            if(digits[i] > 9) {
                digits[i - 1]++;
                digits[i] = digits[i] - 10;
                continue;
            }
            break;
        }
        if(digits[0] > 9) {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            System.arraycopy(digits, 0, temp, 1, digits.length);
            temp[1] = temp[1] - 10;
            return temp;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[] {9, 9, 9})));
    }
}
