package com.leetcode.solution.q0107;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

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

        if (root == null) {
            return result;
        }

        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            int count = nodeList.size();
            List<Integer> nodeIdList = new ArrayList<>();
            for(int i =0; i < count; i ++){
                TreeNode node = nodeList.removeFirst();

                nodeIdList.add(node.val);
                if(node.left != null) {
                    nodeList.add(node.left);
                }
                if(node.right != null) {
                    nodeList.add(node.right);
                }
            }
            result.addFirst(nodeIdList);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
