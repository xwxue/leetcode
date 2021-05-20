package com.leetcode.solution.q1888;

public class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;

        int max = 0;

        for(int j = 0; j < prices.length; j ++) {
            int x = prices[j] - prices[i];
            if(x > max) {
                max = x;
            }
            if(prices[j] < prices[i]) {
                i = j;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new Solution().maxProfit(prices));
    }
}
