package com.leetcode.solution.q1377;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static class Node {
        public int id;
        public double p = 1;
        public int t = 0;

        public Node(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Node, Set<Node>> childrenSetMap = new HashMap<>();
        for(int[] edge : edges) {
            childrenSetMap.computeIfAbsent(new Node(edge[0]), k -> new HashSet<>()).add(new Node(edge[1]));
            childrenSetMap.computeIfAbsent(new Node(edge[1]), k -> new HashSet<>()).add(new Node(edge[0]));
        }
        boolean[] visited = new boolean[n + 1];
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(1));

        Node endNode = null;

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            visited[node.id] = true;
            if(node.id == target) {
                endNode = node;
                break;
            }
            if(node.t >= t) {
                continue;
            }
            Set<Node> children = childrenSetMap.get(node);
            if(children == null) {
                continue;
            }
            children = children.stream().filter(child -> !visited[child.id]).collect(Collectors.toSet());
            for(Node child : children) {
                child.t = node.t + 1;
                child.p = node.p / children.size();
                queue.add(child);
            }
        }
        if(endNode == null) {
            return 0;
        }
        if(endNode.t == t) {
            return endNode.p;
        }
        Set<Node> children = childrenSetMap.get(endNode);
        if(children == null) {
            return endNode.p;
        }
        children = children.stream().filter(child -> !visited[child.id]).collect(Collectors.toSet());
        if(children.isEmpty()) {
            return endNode.p;
        }
        return 0;
    }


    public static void main(String[] args) {
//        int n = 7;
//        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
//        int t = 2, target = 4;

        int n = 7;
        int[][] edges ={{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int t = 1, target = 7;

        System.out.println(new Solution().frogPosition(n, edges, t, target));
    }
}
