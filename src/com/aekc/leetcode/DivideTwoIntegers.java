package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-27 下午2:57
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dd = Math.abs((long)dividend), ds = Math.abs((long)divisor);
        int sign = 1;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = 0;
        }
        int ans = 0;
        while(dd >= ds) {
            long res = 1;
            long tmp = ds;
            while(dd >= (tmp << 1)) {
                tmp <<= 1;
                res <<= 1;
            }
            dd -= tmp;
            ans += res;
        }
        return sign == 1 ? ans : -ans;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(7, 3));
    }
}
