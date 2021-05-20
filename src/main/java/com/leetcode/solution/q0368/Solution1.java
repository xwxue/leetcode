package com.leetcode.solution.q0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return list;
    }

    public void dfs(int[] nums, int start, List<Integer> path) {
        if(start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if(addNum(path, num)) {
                path.add(num);
                if(list.size() < path.size()) {
                    list = new ArrayList<>(path);
                }
                dfs(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean addNum(List<Integer> path, int num) {
        if(path.isEmpty()) {
            return true;
        }
        for(int n : path) {
            if(num % n != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        System.out.println(new Solution1().largestDivisibleSubset(nums));
    }
}
