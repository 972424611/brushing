package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twilight
 * @date 2019-02-18 22:40
 */
public class ValidateBinarySearchTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
         val = x;
        }
    }

    private List<Integer> list = new ArrayList<>();

    private boolean flag = true;

    public void checkOrder() {
        if(list != null && list.size() > 1) {
            if(list.get(list.size() - 1) <= list.get(list.size() - 2)) {
                flag = false;
            }
        }
    }

    public void inorder(TreeNode node) {
        checkOrder();
        if(node.left != null && flag) {
            inorder(node.left);
        }
        if(flag) {
            list.add(node.val);
        }
        checkOrder();
        if(node.right != null && flag) {
            inorder(node.right);
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        inorder(root);
        return flag;
    }
}
