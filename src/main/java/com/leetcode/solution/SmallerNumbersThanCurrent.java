package com.leetcode.solution;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = new int[nums.length];
        for(int i =0; i < nums.length; i++)
            for(int j =0; j< nums.length; j++){
                if(i != j){
                    if(nums[j] < nums[i]){
                        res[i] ++;
                    }
                }
            }
        return res;
    }

    public static void main(String[] args) {
        int res[] = new  SmallerNumbersThanCurrent().smallerNumbersThanCurrent(new int[]{});
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
