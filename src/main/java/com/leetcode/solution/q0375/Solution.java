package com.leetcode.solution.q0375;

public class Solution {



    public int getMoneyAmount(int n) {
        int[][] cache = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0; j < n; j++){
                cache[i][j] = -1;
            }
        }
        return calcMoney(1, n, cache);
    }

    private int calcMoney(int low, int high, int[][] cache){
        if(low >= high){
            return 0;
        }
        int c = cache[low - 1][high -1];
        if(c != -1){
            return c;
        }
        int min = Integer.MAX_VALUE;
        for(int i = low; i<=high; i++){
            int res = i + Integer.max(calcMoney(low, i - 1, cache), calcMoney(i + 1, high, cache));
            min = Integer.min(min, res);
        }
        cache[low - 1][high - 1] = min;
        return min;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}
