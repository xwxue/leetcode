package com.leetcode.solution.q1763;

public class Solution {
    public String longestNiceSubstring(String s) {
        int max = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = 0;
            int b = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c >= 'a' && c <= 'z') {
                    a |= (1 << c - 'a');
                } else {
                    b |= (1 << c - 'A');
                }
                int len = j - i + 1;
                if(a == b && len > max) {
                    max = len;
                    l = i;
                    r = j;
                }
            }
        }
        return max > 0 ? s.substring(l, r + 1) : "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestNiceSubstring("Bb"));
    }
}
