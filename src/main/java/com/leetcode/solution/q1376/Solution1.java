package com.leetcode.solution.q1376;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    Map<Integer, Set<Integer>> subordinateMap = new HashMap<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n <= 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            subordinateMap.computeIfAbsent(manager[i], k -> new HashSet<>()).add(i);
        }

        return dfs(headID, informTime[headID], informTime);
    }

    private int dfs(int id, int time, int[] informTime) {
        Set<Integer> subordinates = subordinateMap.get(id);
        if(subordinates == null || subordinates.isEmpty()) {
            return time;
        }
        int maxTime = 0;
        for(int subordinate : subordinates) {
            maxTime = Math.max(dfs(subordinate, time + informTime[subordinate], informTime), maxTime);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int n = 11;
        int headID = 4;
        int[] manager = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = {0,213,0,253,686,170,975,0,261,309,337};
        System.out.println(new Solution1().numOfMinutes(n, headID, manager, informTime));
    }
}
