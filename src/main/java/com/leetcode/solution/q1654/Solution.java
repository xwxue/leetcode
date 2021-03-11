package com.leetcode.solution.q1654;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for(Integer i : forbidden) {
            forbiddenSet.add(i);
        }
        return jump(forbiddenSet, a, b, x);
    }

    int jump(Set<Integer> forbiddenSet, int a, int b, int x) {
        if((a & 1) == 0 && (b & 1) == 0 && (x & 1)== 1 ) {
            return -1;
        }

        int count = 0;
        int currentPoint = 0;

        int rightCount = 0;

        boolean isBack = false;
        int backCount = 0;
        int backPoint = -1;
        int backNum = 1;

        while (currentPoint != x) {
            if(!isBack) {
                int nextPoint = currentPoint + a;
                if(forbiddenSet.contains(nextPoint) || currentPoint > x) {
                    if(backPoint == -1){
                        backPoint = currentPoint;
                        backCount = count;
                    } else {
                        currentPoint = backPoint;
                        count = backCount;
                        backNum++;
                    }

                    isBack = true;
                } else {
                    currentPoint = nextPoint;
                    count ++;
                }
            } else {
                int nextPoint = currentPoint - b * backNum;
                if(forbiddenSet.contains(nextPoint)) {
                    return -1;
                } else {
                    isBack = false;
                    currentPoint = nextPoint;
                    count += backNum;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {

        int[] forbidden = new int[]{8,3,16,6,12,20};

        int count = new Solution().minimumJumps(forbidden, 15, 13, 11);
        System.out.println(count);

    }
}
