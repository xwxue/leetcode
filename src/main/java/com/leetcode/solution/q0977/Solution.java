package com.leetcode.solution.q0977;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int i = 0;

        while (i < len && nums[i] < 0) {
            i++;
        }
        int[] result = new int[len];
        int j = i - 1;
        for(int a = 0; a < len; a++) {
            if(j < 0) {
                result[a] = nums[i] * nums[i++];
                continue;
            }
            if(i >= len) {
                result[a] = nums[j] * nums[j--];
                continue;
            }
            int x = nums[i] * nums[i];
            int y = nums[j] * nums[j];
            if(x < y) {
                result[a] = x;
                i++;
            } else {
                result[a] = y;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int[] result = new Solution().sortedSquares(nums);
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
