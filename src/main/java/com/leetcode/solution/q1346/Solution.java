package com.leetcode.solution.q1346;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            if(set.contains(n)) {
                return true;
            }
            set.add(n * 2);
            if(n % 2 ==0) {
                set.add(n / 2);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-20,8,-6,-14,0,-19,14,4};
        System.out.println(new Solution().checkIfExist(arr));
    }
}
