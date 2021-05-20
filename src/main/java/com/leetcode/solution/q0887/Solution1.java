package com.leetcode.solution.q0887;


public class Solution1 {

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }


    private int dp(int k, int n) {
        if(k == 1) {
            return n;
        }
        if(n == 1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int max = Math.max(dp(k, n - i), dp(k - 1, i - 1));
            if(max < min) {
                min = max;
            }
        }

        return 1 + min;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution1().superEggDrop(8,1000));
        System.out.println(System.currentTimeMillis() - start);
    }
}
