package com.leetcode.solution.q1911;

import java.util.*;

public class Solution1 {
    private List<String> res = new LinkedList<>();
    private char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    public static void main(String[] args) {
        String s = "abc";
        String[] permutation = new Solution1().permutation(s);
        System.out.println(permutation.length);
        System.out.println(Arrays.toString(new Solution1().permutation(s)));
    }
}
