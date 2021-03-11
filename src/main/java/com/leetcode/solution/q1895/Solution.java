package com.leetcode.solution.q1895;

public class Solution {
    public String compressString(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }
        char prev = S.charAt(0);
        int l = 1;
        StringBuffer zip = new StringBuffer();
        for(int i = 1; i < S.length(); i ++) {
            char c = S.charAt(i);
            if(prev == c) {
                l ++;
            } else {
                zip.append(prev).append(l);
                prev = c;
                l = 1;
            }
        }
        zip.append(prev).append(l);
        return zip.length() < S.length() ? zip.toString() : S;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compressString("aabcccccaaa"));
    }
}
