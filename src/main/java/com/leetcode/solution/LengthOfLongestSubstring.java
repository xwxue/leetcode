package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/*
给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

* */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int a = 0;
        int b = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null) {
                int len = b -a;
                if(len > max){
                    max = len;
                }
                for(int j = a; j < index; j ++){
                    map.remove(s.charAt(j));
                }
                a = index + 1;
            }
            b ++;
            map.put(c, i);
        }
        int len = b - a;
        if(len > max){
            max = len;
        }
        return max;
    }
}
