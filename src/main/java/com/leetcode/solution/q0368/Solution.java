package com.leetcode.solution.q0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 1) {
            return Collections.singletonList(nums[0]);
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }
        if(maxSize == 1) {
            list.add(maxValue);
            return list;
        }
        for (int i = nums.length - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                list.add(nums[i]);
                maxValue = nums[i];
                maxSize--;
            }
        }

        return list;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        System.out.println(new Solution().largestDivisibleSubset(nums));
    }
}
