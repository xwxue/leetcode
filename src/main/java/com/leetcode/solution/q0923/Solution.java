package com.leetcode.solution.q0923;

import java.util.Arrays;

public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = (int)10e7 + 1;
        Arrays.sort(arr);
        int result = 0;
        for(int s = 0; s < arr.length; s ++) {
            int num = target - arr[s];
            int i = s + 1;
            int j = arr.length - 1;



            while (i < j) {
                int tmp = arr[i] + arr[j];
                if(tmp > num) {
                    j --;
                } else if(tmp < num) {
                    i ++;
                } else if(arr[i] != arr[j]) {
                    int t = i + 1;

                    int left = 1;
                    int right = 1;

                    while (arr[t++] == arr[i] && t < j) {
                        left ++;
                    }
                    t = j - 1;
                    while (arr[t--] == arr[j] && t > i) {
                        right ++;
                    }
                    result = result + left * right;
                    result = result % mod;
                    i ++;
                    j --;
                } else {
                    result += (j-i+1) * (j-i) / 2;
                    result %= mod;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        System.out.println(new Solution().threeSumMulti(arr, target));
    }
}
