package com.leetcode.solution.q0087;

import java.util.*;

public class Solution {

    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        if(s1.length() != s2.length()) {
            return false;
        }
        Boolean result = cache.get(getKey(s1, s2));
        if(result != null) {
            return result;
        }
        for (int i = 1; i < s1.length(); i++) {
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i);

            String left2 = s2.substring(0, i);
            String right2 = s2.substring(i);

            if(isScramble(left1, left2) && isScramble(right1, right2)) {
                cache.put(getKey(s1, s2), true);
                return true;
            }
            int j = s1.length() - i;
            left2 = s2.substring(0, j);
            right2 = s2.substring(j);
            if(isScramble(left1, right2) && isScramble(right1, left2)) {
                cache.put(getKey(s1, s2), true);
                return true;
            }
        }
        cache.put(getKey(s1, s2), false);
        return false;
    }

    private Map<String, Boolean> cache = new HashMap<>();


    private String getKey(String s1, String s2) {
        if(s1.compareTo(s2) > 0) {
            return s1 + "_" + s2;
        } else {
            return s2 + "_" + s1;
        }
    }


    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopq";
        String s2 = "efghijklmnopqcadb";
        long start = System.currentTimeMillis();
        System.out.println(new Solution().isScramble(s1, s2));
        System.out.println((System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
