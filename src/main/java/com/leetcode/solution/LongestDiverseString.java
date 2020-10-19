package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/*
如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

s 是一个尽可能长的快乐字符串。
s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

 

示例 1：

输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。
示例 2：

输入：a = 2, b = 2, c = 1
输出："aabbc"
示例 3：

输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。
*/
public class LongestDiverseString {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> map = new HashMap<>(4);
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        StringBuffer sb = new StringBuffer();
        char prevChar = ' ';
        while (true){
            char[] chars = getMasterString(map, prevChar);
            if(chars == null){
                break;
            }
            sb.append(chars);
            prevChar = chars[0];
            map.put(prevChar, map.get(prevChar) - chars.length);

            chars = getIntervalString(map, prevChar);
            if(chars == null){
                break;
            }
            sb.append(chars);
            prevChar = chars[0];
            map.put(prevChar, map.get(prevChar) - chars.length);
        }
        return sb.toString();
    }

    public char[] getMasterString(Map<Character, Integer> map, char prevChar){
        int max = -1;
        char c = ' ';
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if(e.getKey().equals(prevChar)){
                continue;
            }
            int num = e.getValue();
            if(num > max){
                max = num;
                c = e.getKey();
            }
        }
        if(max > 1){
            return new char[]{c, c};
        }else if(max > 0){
            return new char[]{c};
        }else {
            return null;
        }
    }

    public char[] getIntervalString(Map<Character, Integer> map, char prevChar){
        int prevLen = map.get(prevChar);

        int needIntervalNum = (prevLen - 1) / 2 + 1;

        int totalLen = 0;

        int max = -1;
        char c = ' ';

        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getKey().equals(prevChar)) {
                continue;
            }
            totalLen += e.getValue();

            int num = e.getValue();
            if(num > max){
                max = num;
                c = e.getKey();
            }

        }
        if(max < 1){
            return null;
        }
        if(totalLen <= needIntervalNum){
            return new char[]{c};
        }else{
            if(max > 1){
                return new char[]{c, c};
            } else {
                return new char[]{c};
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestDiverseString().longestDiverseString(0, 0, 0));
    }
}
