package com.leetcode.solution.q1911;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> result = dfs(chars);
        return result.toArray(new String[0]);
    }

    private Set<String> dfs(char[] chars) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '0') {
                continue;
            }
            chars[i] = '0';
            Set<String> tmp = dfs(chars);
            if (tmp.isEmpty()) {
                result.add(String.valueOf(c));
            } else {
                tmp.forEach(s -> {
                    result.add(s + c);
                    result.add(c + s);
                });
            }
            chars[i] = c;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] permutation = new Solution1().permutation(s);
        System.out.println(permutation.length);
        System.out.println(Arrays.toString(new Solution1().permutation(s)));
    }
}
