package com.leetcode.solution.q1037;

public class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        return !( (x1-x3)*(y1-y2) == (x1-x2)*(y1-y3) );
    }

    public static void main(String[] args) {
        boolean boomerang = new Solution().isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        System.out.println(boomerang);
    }
}
