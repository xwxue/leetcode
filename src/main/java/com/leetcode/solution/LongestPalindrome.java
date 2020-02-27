package com.leetcode.solution;

/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
* */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String max = s.length() > 0 ? s.substring(0, 1) : "";
        for(int i = 1; i < s.length(); i++){
            String tmp = palindrome(s, i - 1, i + 1);
            if(tmp.length() > max.length()){
                max = tmp;
            }
            tmp = palindrome(s, i - 1, i);
            if(tmp.length() > max.length()){
                max = tmp;
            }
        }

        return max;
    }

    public String palindrome(String s, int a, int b){
        while (a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)){
            a --;
            b ++;
        }
        a ++;
        b --;
        return s.substring(a, b + 1);
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("c");
    }
}
