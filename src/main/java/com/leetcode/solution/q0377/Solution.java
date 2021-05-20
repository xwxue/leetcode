package com.leetcode.solution.q0377;

import java.util.Arrays;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(num <= i) {
                    dp[i] += dp[i - num];
                } else {
                    break;
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int target = 9;
        int i = new Solution().combinationSum4(nums, target);
        System.out.println(i);
    }
}
