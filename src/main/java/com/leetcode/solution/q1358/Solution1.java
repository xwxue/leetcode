package com.leetcode.solution.q1358;

public class Solution1 {
    public int numberOfSubstrings(String ss) {
        char[] s = ss.toCharArray();
        int[] cnt = new int[3];
        int len=ss.length(),ans=0;
        for (int l=0,r=-1;l<len;){
            while (r<len && !(cnt[0]>=1 && cnt[1]>=1 && cnt[2]>=1)){
                if (++r==len) break;
                cnt[s[r]-'a']++;
            }
            ans+=len-r;
            cnt[s[l++]-'a']--;
        }
        return ans;
    }

    public static void main(String[] args) {
        
        System.out.println(new Solution1().numberOfSubstrings("abcd"));
    }
}
