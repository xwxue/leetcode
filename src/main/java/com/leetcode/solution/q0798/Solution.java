package com.leetcode.solution.q0798;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int bestRotation(int[] A) {
        int len = A.length;
        int[] leftK = new int[len];
        int[] rightK = new int[len];
        int[] count = new int[len];
        for (int i = 0; i <len ; i++) {
            if(A[i] >= len) {
                continue;
            }
            int maxLeftMove = i - A[i];
            if(maxLeftMove >= 0 && maxLeftMove < len) {
                leftK[maxLeftMove] ++;
            }
            int minLeftMove = i + 1;
            if(A[i] <= i && i < len - 1) {
                rightK[minLeftMove] ++;
            } else {
                int maxRightMove = len + maxLeftMove;
                if(maxRightMove >=0 && maxRightMove < len) {
                    for(int j = minLeftMove; j <= maxRightMove; j++) {
                        count[j]++;
                    }
                }
            }

        }
        for (int i = len - 2; i >= 0; i--) {
            leftK[i] = leftK[i] + leftK[i + 1];
        }
        for(int i = 0; i < len - 1; i++) {
            rightK[i + 1] = rightK[i] + rightK[i + 1];
        }
        int ret = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int tmp = leftK[i] + rightK[i] + count[i];
            if(tmp > max) {
                max = tmp;
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = {6,2,8,3,5,2,4,3,7,6};
        System.out.println(new Solution().bestRotation(A));
    }
}
