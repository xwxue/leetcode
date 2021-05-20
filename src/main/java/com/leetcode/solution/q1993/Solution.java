package com.leetcode.solution.q1993;

public class Solution {
    public int trap(int[] height) {
        if(height.length < 3) {
            return 0;
        }
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if(leftMax < rightMax) {
                result += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            } else {
                result += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new Solution().trap(height));
    }
}
