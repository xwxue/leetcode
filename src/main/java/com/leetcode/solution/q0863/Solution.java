package com.leetcode.solution.q0863;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null) {
            return Collections.emptyList();
        }
        if(K ==0 ){
            return Collections.singletonList(target.val);
        }
        Map<Integer, Set<Integer>> nodeToNextNodesMap = new HashMap<>();

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.removeFirst();
            if(node.left != null) {
                nodes.add(node.left);
                nodeToNextNodesMap.computeIfAbsent(node.val, k -> new HashSet<>()).add(node.left.val);
                nodeToNextNodesMap.computeIfAbsent(node.left.val, k -> new HashSet<>()).add(node.val);
            }
            if(node.right != null) {
                nodes.add(node.right);
                nodeToNextNodesMap.computeIfAbsent(node.val, k -> new HashSet<>()).add(node.right.val);
                nodeToNextNodesMap.computeIfAbsent(node.right.val, k -> new HashSet<>()).add(node.val);
            }
        }
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> nodeIds = new LinkedList<>();
        nodeIds.add(target.val);
        int k = 0;
        while (!nodeIds.isEmpty()) {
            int size = nodeIds.size();
            for (int i = 0; i < size; i++) {
                Integer nodeId = nodeIds.remove();
                visited.add(nodeId);
                Set<Integer> nodeSet = nodeToNextNodesMap.get(nodeId);
                if(nodeSet != null) {
                    nodeIds.addAll(nodeSet.stream().filter(id -> !visited.contains(id)).collect(Collectors.toSet()));
                }
            }
            k ++;
            if(k == K) {
                return nodeIds;
            }
        }
        return Collections.emptyList();
    }
}
