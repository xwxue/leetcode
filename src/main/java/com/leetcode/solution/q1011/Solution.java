package com.leetcode.solution.q1011;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int right = 0;
        int left = 0;
        for (int weight : weights) {
            right += weight;
            if(weight > left) {
                left = weight;
            }
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int day = 1;
            int sum = 0;
            for (int weight : weights) {
                if(sum + weight > mid) {
                    day ++;
                    sum = 0;
                }
                sum += weight;
            }
            if(day <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(new Solution().shipWithinDays(weights, D));
    }
}
