package com.leetcode.solution.q0087;

import java.util.*;

public class Solution1 {

    private Map<String, Set<String>> cache = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        return scramble(s1).contains(s2);
    }

    private Set<String> scramble(String s) {
        if(s.length() == 1) {
            return Collections.singleton(s);
        }
        Set<String> result = cache.get(s);
        if(result != null) {
            return result;
        }
        result = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            Set<String> leftList = scramble(left);
            Set<String> rightList = scramble(right);
            for (String l : leftList) {
                for (String r : rightList) {
                    result.add(l + r);
                    result.add(r + l);
                }
            }
        }
        cache.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        String s1 = "1234567890123";
        String s2 = "bdacabcdbdac";
        long start = System.currentTimeMillis();
        System.out.println(new Solution1().scramble(s1).contains(s2));
        System.out.println((System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
