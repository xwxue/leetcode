package com.leetcode.solution.q1742;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = lowLimit; i <= highLimit; i++) {
            int n = i;
            int j = 0;
            while (n > 0) {
                j += n % 10;
                n = n / 10;
            }
            int c = map.getOrDefault(j, 0);
            map.put(j, c + 1);
        }
        int max = Integer.MIN_VALUE;
        for(int n : map.values()) {
            if(n > max) {
                max = n;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(19, 28));
    }
}
