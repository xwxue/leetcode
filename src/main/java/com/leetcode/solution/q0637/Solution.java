package com.leetcode.solution.q0637;

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (root == null) {
            return avgList;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            avgList.add(sum / size);
        }
        return avgList;
    }
}
