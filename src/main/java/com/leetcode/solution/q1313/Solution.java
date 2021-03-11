package com.leetcode.solution.q1313;



public class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for(int i = 0; i < nums.length; i+=2){
            len += nums[i];
        }
        int[] res = new int[len];
        int j = 0;
        for(int i = 0; i < nums.length / 2; i++){
            int freq = nums[2 * i];
            int val = nums[2 * i + 1];
            for(int a = 0; a < freq; a++){
                res[j++] = val;
            }
        }

        return res;
    }
}
