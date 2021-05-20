package com.leetcode.solution.q0897;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode head = null;
    TreeNode current = null;

    public TreeNode increasingBST(TreeNode root) {
        bf(root);
        return head;
    }

    private void bf(TreeNode node) {
        if(node == null) {
            return;
        }
        bf(node.left);
        TreeNode right = node.right;
        node.left = null;
        node.right = null;
        if(head == null) {
            head = node;
            current = node;
        } else {
            current.right = node;
            current = current.right;
        }
        bf(right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node = new Solution().increasingBST(head);
        System.out.println(node);
    }
}
