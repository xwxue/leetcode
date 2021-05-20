package com.leetcode.solution.q1626;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public class People {
        public int score;
        public int age;

        public People(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        People[] peoples = new People[scores.length];
        for (int i = 0; i < scores.length; i++) {
            peoples[i] = new People(scores[i], ages[i]);
        }
        Arrays.sort(peoples, (a, b) -> {
            if(a.age != b.age) {
                return a.age - b.age;
            } else {
                return a.score - b.score;
            }
        });

        int[] dp = new int[ages.length];

        int result = 0;

        for (int i = 0; i < peoples.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(peoples[j].score <= peoples[i].score) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = peoples[i].score + max;
            result = Math.max(result, dp[i]);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] scores = {319776,611683,835240,602298,430007,574,142444,858606,734364,896074};
        int[] ages = {1,1,1,1,1,1,1,1,1,1};

        System.out.println(new Solution().bestTeamScore(scores, ages));
    }
}
