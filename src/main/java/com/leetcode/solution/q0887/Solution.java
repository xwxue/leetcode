package com.leetcode.solution.q0887;



public class Solution {

    public int superEggDrop(int k, int n) {
        if(k == 1) {
            return n;
        }
        if(n == 1) {
            return 1;
        }
        int[][] tb = new int[k + 1][n + 1];
        for(int i = 1; i <=n; i++) {
            tb[1][i] = i;
            tb[0][i] = 0;
        }
        for (int i = 1; i <= k; i++) {
            tb[i][0] = 0;
        }


        for(int i = 2; i <=k; i++) {
            for(int j = 1; j <=n; j++) {
                int min = Integer.MAX_VALUE;
                for(int l = 1; l <= j; l++) {
                    min = Math.min(min, 1 + Math.max(tb[i][j -l], tb[i -1][l -1]));
                }
                tb[i][j] = min;
            }
        }
        return tb[k][n];
    }




    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().superEggDrop(8,10000));
        System.out.println(System.currentTimeMillis() - start);
    }
}
