package com.leetcode.solution.q0213;

public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        } else if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int t = second;
            second = Math.max(first + nums[i], second);
            first = t;
        }
        return second;
    }


    public static void main(String[] args) {
        int[] nums = {1 ,4, 5, 5};
        System.out.println(new Solution().rob(nums));
    }

}
