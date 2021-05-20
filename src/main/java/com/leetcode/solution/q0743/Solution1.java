package com.leetcode.solution.q0743;

import java.util.*;

public class Solution1 {
    int[] nodeTime;
    public int networkDelayTime(int[][] times, int n, int k) {
        nodeTime = new int[n];
        Arrays.fill(nodeTime, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            time[0] --;
            time[1] --;
            map.computeIfAbsent(time[0], key -> new ArrayList<>()).add(time);
        }
        for (List<int[]> edges: map.values()) {
            Collections.sort(edges, (a, b) -> a[0] - b[0]);
        }
        dfs(map, k - 1, 0);

        int maxTime = -1;
        for (int i = 0; i < nodeTime.length; i++) {
            int t = nodeTime[i];
            if (i != k && t == 0) {
                return -1;
            }
            if (t > maxTime) {
                maxTime = t;
            }
        }
        return maxTime;
    }

    private void dfs(Map<Integer, List<int[]>> map, int nodeIndex, int nodeDist) {
        if(nodeDist >= nodeTime[nodeIndex]) {
            return;
        }
        nodeTime[nodeIndex] = nodeDist;
        List<int[]> nodeEdges = map.get(nodeIndex);
        if(nodeEdges != null) {
            for(int[] edge : nodeEdges) {
                int bNodeDist = nodeDist + edge[2];
                dfs(map, edge[1], bNodeDist);
            }
        }
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        System.out.println(new Solution1().networkDelayTime(times, 5, 5));
    }
}
