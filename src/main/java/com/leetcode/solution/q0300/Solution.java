package com.leetcode.solution.q0300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] lens = new int[nums.length];
        lens[0] = 1;

        int result = 1;

        for(int j = 1; j < nums.length; j++) {
            int max = 0;
            for(int i = 0; i < j; i++) {
                if(nums[j] > nums[i]) {
                    max = Math.max(max, lens[i]);
                }
            }
            lens[j] = ++max;
            result = Math.max(max, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
