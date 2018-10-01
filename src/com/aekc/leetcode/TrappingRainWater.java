package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-1 下午5:36
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int max = 0;
        int start = 0, end = 0;
        int x = 0, y;
        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max) {
                max = height[i];
            }
            y = i;
            if(height[i] >= end) {
                start = end;
                end = height[i];
                sum += start * (y - x - 1);
                for(int j = x + 1; j < y; j++) {
                    sum -= height[j];
                }
                x = y;
            }
        }

        end = 0;
        x = height.length - 1;
        for(int i = height.length - 1; i >= 0; i--) {
            y = i;
            if(height[i] >= end) {
                start = end;
                end = height[i];
                sum += start * (x - y - 1);
                for(int j = y + 1; j < x; j++) {
                    sum -= height[j];
                }
                x = y;
            }
            if(max == height[i]) {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[] {4,3,3,9,3,0,9,2,8,3}));
    }
}
