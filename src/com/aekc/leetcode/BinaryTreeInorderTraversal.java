package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twilight
 * @date 2019-02-17 21:38
 */
public class BinaryTreeInorderTraversal {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> list = new ArrayList<>();

    private void inorder(TreeNode node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }


    public static void main(String[] args) {

    }
}
