package com.leetcode.solution.q0091;

import java.util.Arrays;

public class Solution {
    int[] dp;
    public int numDecodings(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0);
    }

    private int dfs(String s, int start) {
        if(start >= s.length()) {
            return 1;
        }
        if(dp[start] != -1) {
            return dp[start];
        }
        char c = s.charAt(start);
        if(c == '0') {
            return 0;
        }
        int one = dfs(s, start + 1);
        int two = 0;
        if(start < s.length() - 1) {
            int num = (c - '0') * 10 + s.charAt(start + 1) - '0';
            if(num <= 26) {
                two = dfs(s, start + 2);
            }
        }
        int result = one + two;
        dp[start] = result;
        return result;
    }

    public static void main(String[] args) {
        String s = "30212121";
        System.out.println(new Solution().numDecodings(s));
    }
}
