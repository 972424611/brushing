package com.aekc.leetcode;

import java.util.LinkedList;

/**
 * @author Twilight
 * @date 18-10-3 下午1:41
 */
public class JumpGameTwo {

    public int bfs(int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] size = new int[nums.length];
        int[] parent = new int[nums.length];
        parent[0] = -1;
        queue.offer(0);
        int sum = 0;
        int k = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            if(u == 0 || parent[k] != parent[u]) {
                if(u != 0) {
                    sum = size[parent[u] - 1];
                }
                sum++;
            }
            int p = nums[u] + u >= nums.length ? nums.length - 1 : nums[u] + u;
            for(int j = p; j > u; j--) {
                if(parent[j] == 0) {
                    if(j == parent.length - 1) {
                        return sum;
                    }
                    queue.offer(j);
                    parent[j] = u + 1;
                }
            }
            k = u;
            size[u] = sum;
        }
        return sum;
    }

    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        return bfs(nums);
    }

    public static void main(String[] args) {
        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        System.out.println(jumpGameTwo.jump(new int[]{2,1}));
    }
}
