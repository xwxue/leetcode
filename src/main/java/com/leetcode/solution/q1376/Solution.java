package com.leetcode.solution.q1376;

import java.util.*;

public class Solution {
    Map<Integer, Set<Integer>> subordinateMap = new HashMap<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n <= 1) {
            return 0;
        }

        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            if(informTime[i] == 0) {
                int leader = manager[i];
                int time = 0;
                while (leader != -1) {
                    time += informTime[leader];
                    leader = manager[leader];
                }
                maxTime = Math.max(maxTime, time);
            }
        }

        return maxTime;
    }


    public static void main(String[] args) {
        int n = 11;
        int headID = 4;
        int[] manager = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = {0,213,0,253,686,170,975,0,261,309,337};
        System.out.println(new Solution().numOfMinutes(n, headID, manager, informTime));
    }
}
