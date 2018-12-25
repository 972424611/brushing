package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-12-25 下午3:38
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i = 0; i < heights.length; i++) {
            if(i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }
            int minHeight = heights[i];
            for(int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (i - j + 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
