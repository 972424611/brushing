package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 2019-02-19 10:44
 * 找到最大最小值，然后替换就行
 */
public class RecoverBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode minElement = new TreeNode(Integer.MAX_VALUE);
    TreeNode maxElement = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        traverse(root, null, null);
        int temp = minElement.val;
        minElement.val = maxElement.val;
        maxElement.val = temp;
    }

    private void traverse(TreeNode node, TreeNode left, TreeNode right) {
        if(node == null) {
            return;
        }
        traverse(node.left, node, right);
        if(left != null && node.val > left.val) {
            if(minElement.val > left.val) {
                minElement = left;
            }
            if(maxElement.val < node.val) {
                maxElement = node;
            }
        }
        if(right != null && node.val < right.val) {
            if(minElement.val > node.val) {
                minElement = node;
            }
            if(maxElement.val < right.val) {
                maxElement = right;
            }
        }
        traverse(node.right, left, node);
    }
}
