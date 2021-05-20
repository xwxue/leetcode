package com.leetcode.solution.q0518;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for (int i = coin; i <= amount; i++){
                if(coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }

        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {5,2,1};
        System.out.println(new Solution().change(5, coins));
    }
}
