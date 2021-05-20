package com.leetcode.solution.q0264;


public class Solution {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int n2 = dp[p2] * 2;
            int n3 = dp[p3] * 3;
            int n5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) {
                p2 ++;
            }
            if(dp[i] == n3) {
                p3 ++;
            }
            if(dp[i] == n5) {
                p5 ++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
