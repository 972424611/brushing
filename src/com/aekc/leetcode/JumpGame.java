package com.aekc.leetcode;

import java.util.LinkedList;

/**
 * @author Twilight
 * @date 18-10-15 下午6:04
 */
public class JumpGame {

    public boolean bfs(int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] parent = new int[nums.length];
        parent[0] = -1;
        queue.offer(0);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            int p = nums[u] + u >= nums.length ? nums.length - 1 : nums[u] + u;
            for(int j = p; j > u; j--) {
                if(parent[j] == 0) {
                    if(j == parent.length - 1) {
                        return true;
                    }
                    queue.offer(j);
                    parent[j] = u + 1;
                }
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }
        return bfs(nums);
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[] {3, 2, 1, 0, 4}));
    }
}
