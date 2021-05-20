package com.leetcode.solution.q0081;

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return nums[0] == target;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }

            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid -1;
                }
            }
        }
        return false;
    }
}
