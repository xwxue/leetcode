package com.leetcode.solution.q0279;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSquares(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(0, 0);
        for(int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= Math.sqrt(i); j++){
                min = Math.min(min, 1 + cache.get(i - j * j));
            }
            cache.put(i, min);
        }

        return cache.get(n);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(4080800));
    }
}
