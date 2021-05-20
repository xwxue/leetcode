package com.leetcode.solution.q0743;

import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer> nodeDist = new HashMap<>();

        Map<Integer, List<int[]>> nodeEdgesMap = new HashMap<>();
        for (int[] time : times) {
            nodeEdgesMap.computeIfAbsent(time[0], key -> new ArrayList<>()).add(time);
        }

        for(int i = 1; i <= n; i ++) {
            nodeDist.put(i, Integer.MAX_VALUE);
        }

        nodeDist.put(k, 0);

        boolean[] visited = new boolean[n + 1];

        Arrays.fill(visited, false);

        while (true) {
            int minNode = -1;
            int minDist = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i ++) {
                Integer tmpDist = nodeDist.get(i);
                if(!visited[i] && tmpDist < minDist) {
                    minNode = i;
                    minDist = tmpDist;
                }
            }
            if(minNode == -1) {
                break;
            }
            visited[minNode] = true;
            List<int[]> edges = nodeEdgesMap.get(minNode);
            if(edges == null) {
                continue;
            }
            for(int[] edge : edges) {
                nodeDist.put(edge[1], Math.min(nodeDist.get(edge[1]), minDist + edge[2]));
            }
        }


        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i ++) {
            Integer dist = nodeDist.get(i);
            if(dist == Integer.MAX_VALUE) {
                return -1;
            }
            if(dist > max) {
                max = dist;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}, {1,2,1}, {2, 4, 5}};
        System.out.println(new Solution().networkDelayTime(times, 4, 2));
    }
}
