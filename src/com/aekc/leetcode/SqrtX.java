package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-21 下午6:03
 */
public class SqrtX {

    public int mySqrt(int x) {
        int left = 1;
        int right = Math.min(x, 46340);
        while(left <= right) {
            int middle = (left + right) / 2;
            int temp = middle * middle;
            if(temp == x) {
                return middle;
            }
            if(temp < x) {
                left++;
            }
            if(temp > x) {
                right--;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(9));
    }
}
