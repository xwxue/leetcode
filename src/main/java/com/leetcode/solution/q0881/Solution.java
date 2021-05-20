package com.leetcode.solution.q0881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int result = 0;
        while (i < j) {
            int weight = people[i] + people[j];
            if(weight <= limit) {
                j --;
                i ++;
            } else {
                j --;
            }
            result ++;
        }
        if(i == j) {
            result ++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] peoples = {3,2,2,1};
        int limit = 3;
        System.out.println(new Solution().numRescueBoats(peoples, limit));
    }
}
