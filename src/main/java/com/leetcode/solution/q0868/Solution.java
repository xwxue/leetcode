package com.leetcode.solution.q0868;

public class Solution {
    public int binaryGap(int n) {
        int lastIndex = -1;
        int i = 0;
        int max = 0;
        while (n != 0) {
            if((n & 1) == 1) {
                if(lastIndex != -1) {
                    int t = i - lastIndex;
                    if(t > max) {
                        max = t;
                    }
                }

                lastIndex = i;
            }
            i ++;
            n >>= 1;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().binaryGap(2));
    }
}
