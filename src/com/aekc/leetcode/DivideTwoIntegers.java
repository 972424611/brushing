package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-27 下午2:57
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(divisor == 1) {
            return dividend;
        }
        int x = dividend;
        int y = divisor;
        boolean flag = false;
        if(dividend == Integer.MIN_VALUE) {
            dividend = -1 * Integer.MAX_VALUE;
            flag = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0;
        while(dividend >= divisor) {
            dividend -= divisor;
            sum++;
        }
        if((x > 0 && y > 0) || (x < 0 && y < 0) || -(x * y) == Integer.MIN_VALUE) {
            if(flag) {
                return Integer.MAX_VALUE;
            }
            return sum;
        } else {
            if(flag) {
                return -1 * sum + -1;
            }
            return -1 * sum;
        }
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(2147483647, 2));
    }
}
