package com.leetcode.solution.q0070;

public class Solution {
    public int climbStairs(int n) {
        if(n < 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int climbStairs2(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(10));
        System.out.println(new Solution().climbStairs2(10));
    }
}
