package com.leetcode.solution.q0530;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int min = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {

        visit(root);

        return min;
    }

    public void visit(TreeNode node) {
        if(node == null) {
            return;
        }
        visit(node.left);
        if (pre != -1) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        visit(node.right);
    }
}
