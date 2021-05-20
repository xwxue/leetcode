package com.leetcode.solution.q0080;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) {
           return nums.length;
        }
        int p = 1;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(prev == nums[i]) {
                count ++;
            } else {
                prev = nums[i];
                count = 1;
            }
            if(count < 3) {
                if(p != i) {
                    nums[p] = nums[i];
                }
                p ++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3,3,3,3,3,3,3,3,3};
        int i = new Solution().removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}
