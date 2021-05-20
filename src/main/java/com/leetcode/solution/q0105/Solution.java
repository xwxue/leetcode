package com.leetcode.solution.q0105;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, size - 1, 0, size - 1, inorderIndexMap);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight, Map<Integer, Integer> inorderIndexMap) {
        if(pLeft > pRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pLeft]);
        int inorderIndex = inorderIndexMap.get(node.val);

        int inorderLeftSize = inorderIndex - iLeft;

        node.left = buildTree(preorder, inorder, pLeft + 1, pLeft + inorderLeftSize, iLeft, inorderIndex - 1, inorderIndexMap);
        node.right = buildTree(preorder, inorder, pLeft + inorderLeftSize + 1, pRight, inorderIndex + 1, iRight, inorderIndexMap);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new Solution().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
