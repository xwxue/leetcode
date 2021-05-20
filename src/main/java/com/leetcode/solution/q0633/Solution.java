package com.leetcode.solution.q0633;

public class Solution {
    public boolean judgeSquareSum(int c) {

        for (int i = 0; i <= Math.sqrt(c); i++) {
            double b = Math.sqrt(c - i * i);
            if(b == (int)b) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(5));
    }
}
