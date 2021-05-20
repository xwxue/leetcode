package com.leetcode.solution.q1358;

public class Solution {
    public int numberOfSubstrings(String s) {
        if(s == null || s.length() < 3) {
            return 0;
        }
        int count  = 0;
        int j = -1;
        int[] cnt = new int[3];
        for (int i = 0; i < s.length(); i++) {

            int n = s.charAt(i) - 'a';
            if(n > 2) {
                continue;
            }

            while (j < s.length() && !(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0)) {
                if(++j == s.length()) {
                    break;
                }
                n = s.charAt(j) - 'a';
                if(n > 2) {
                    continue;
                }
                cnt[n] ++;
            }
            count += (s.length() - j);
            cnt[s.charAt(i) - 'a'] --;
        }
        return count;
    }

    public static void main(String[] args) {
        
        System.out.println(new Solution().numberOfSubstrings("dabcabc"));
    }
}
