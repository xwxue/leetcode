package com.leetcode.solution.q0473;


import java.util.*;

public class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int edgeLength = sum / 4;

        if(edgeLength * 4 != sum) {
            return false;
        }

        Arrays.sort(nums);

        for(int i = 0; i < 4; i++) {
            if(!makeEdge(edgeLength, 0, nums)) {
                return false;
            }
        }
        return true;
    }

    private boolean makeEdge(int edgeLength, int currentLength, int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if(num == 0) {
                continue;
            }
            int tmpLength = currentLength + num;
            if(tmpLength == edgeLength) {
                nums[i] = 0;
                return true;
            }
            if(tmpLength > edgeLength) {
                return false;
            }
            nums[i] = 0;
            if(makeEdge(edgeLength, tmpLength, nums)) {
                return true;
            } else {
                nums[i] = num;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(new Solution().makesquare(nums));
    }
}
