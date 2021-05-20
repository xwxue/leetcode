package com.leetcode.solution.q0216;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, 0, n, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int k, int sum, int target, int start, List<Integer> list) {
        if(list.size() >= k || sum >= target) {
            if(list.size() == k && sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i < 10; i++) {
            list.add(i);
            dfs(k, sum + i, target, i + 1, list);
            list.remove(list.size() - 1);
        }

    }



    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}
