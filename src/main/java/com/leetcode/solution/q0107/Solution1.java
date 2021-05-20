package com.leetcode.solution.q0107;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public class TreeNode {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();

        if (root == null) {
            return result;
        }

        nodeList.add(root);
        levelList.add(0);

        int prevLevel = 0;
        List<Integer> nodeIdList = new ArrayList<>();

        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.removeFirst();
            int level = levelList.removeFirst();
            if (prevLevel != level) {
                result.addFirst(nodeIdList);
                nodeIdList = new ArrayList<>();
                prevLevel = level;
            }
            nodeIdList.add(node.val);
            if(node.left != null) {
                nodeList.add(node.left);
                levelList.add(level + 1);
            }
            if(node.right != null) {
                nodeList.add(node.right);
                levelList.add(level + 1);
            }
        }

        result.addFirst(nodeIdList);

        return result;
    }

    public static void main(String[] args) {

    }
}
