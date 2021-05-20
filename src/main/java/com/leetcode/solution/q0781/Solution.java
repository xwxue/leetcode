package com.leetcode.solution.q0781;

import java.util.Arrays;

public class Solution {
    public int numRabbits(int[] answers) {
        if(answers == null || answers.length < 1) {
            return 0;
        }
        if(answers.length < 2) {
            return answers[0] + 1;
        }
        Arrays.sort(answers);
        int prevAnswer = answers[0];
        int sameNum = 1;
        int count = 0;

        for (int i = 1; i < answers.length; i++) {
            if(prevAnswer == answers[i]) {
                sameNum ++;
                if(sameNum > prevAnswer + 1) {
                    count += prevAnswer + 1;
                    sameNum = 1;
                }

            } else {
                count += prevAnswer + 1;
                prevAnswer = answers[i];
                sameNum = 1;
            }
        }
        count += prevAnswer + 1;
        return count;
    }

    public static void main(String[] args) {
        int[] answers = {0,0,1,1,1};
        System.out.println(new Solution().numRabbits(answers));
    }
}
