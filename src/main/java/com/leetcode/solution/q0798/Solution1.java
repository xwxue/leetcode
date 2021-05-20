package com.leetcode.solution.q0798;

public class Solution1 {
    public int bestRotation(int[] A) {
        int len = A.length;
        int maxScore = 0;
        int result = 0;
        for(int k = 0; k < A.length; k++) {
            int score = 0;
            for (int i =0; i < A.length; i++) {
                System.out.print(A[(i + k) % len] + " ");
                if(A[(i + k) % len] <= i) {
                    score++;
                }
            }
            System.out.println();
            System.out.println(score);
            if(score > maxScore) {
                maxScore = score;
                result = k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {6,2,8,3,5,2,4,3,7,6};
        System.out.println(new Solution1().bestRotation(A));
    }
}
