package com.leetcode.solution.q0503;


import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] nextGreaterElements1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        int prevMax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && prevMax != -1 && nums[i] < nums[i - 1]) {
                res[i] = prevMax;
                continue;
            }

            int current = nums[i];
            int j = (i + 1) % nums.length;
            boolean flag = false;

            while ( j != i) {
                if(nums[j] > current) {
                    res[i] = nums[j];
                    flag = true;
                    prevMax = nums[j];
                    break;
                }
                j = (j+1)%nums.length;
            }
            if(!flag) {
                prevMax = -1;
                res[i] = -1;
            }
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);

        LinkedList<Integer> stack = new LinkedList<>();

        for(int i = 0; i < len * 2 -1; i ++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                ret[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] res = new Solution().nextGreaterElements(new int[]{5,4,3,2,1});

        for(int i : res) {
            System.out.print(i + " ");
        }

    }
}
