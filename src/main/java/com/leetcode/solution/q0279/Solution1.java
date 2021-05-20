package com.leetcode.solution.q0279;

public class Solution1 {
    public int numSquares(int n) {
        return dp(0, n);
    }

    private int dp(final int count, final int n) {
        if(n < 0) {
            return Integer.MAX_VALUE;
        }
        if(n == 0) {
            return count;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            min = Math.min(min, dp(count + 1, n - i * i));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numSquares(4));
    }
}
