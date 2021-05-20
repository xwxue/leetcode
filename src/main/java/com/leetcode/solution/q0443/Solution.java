package com.leetcode.solution.q0443;

public class Solution {
    public int compress(char[] chars) {
        if(chars.length <= 1) {
            return chars.length;
        }
        StringBuilder sb = new StringBuilder();
        char prev = chars[0];
        int len = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(c == prev) {
                len ++;
            } else {
                sb.append(prev);
                if (len != 1) {
                    sb.append(len);
                }
                prev = c;
                len = 1;
            }
        }
        sb.append(prev);
        if (len != 1) {
            sb.append(len);
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new Solution().compress(chars));
    }
}
