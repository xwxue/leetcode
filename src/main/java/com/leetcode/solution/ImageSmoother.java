package com.leetcode.solution;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int[][] N = new int[M.length][M[0].length];
        for(int i =0; i< M.length; i++){
            for(int j = 0; j < M[i].length; j++){
                N[i][j] = pointSmoother(M, i, j);
            }
        }
        return N;
    }
    int pointSmoother(int[][] M, int i, int j){
        int num= 1;
        int sum = M[i][j];
        int x, y;
        if((x = i - 1) >=0 && (y = j - 1) >=0){
            num ++;
            sum += M[x][y];
        }
        if((x = i - 1) >=0){
            num ++;
            sum += M[x][j];
        }
        if((x = i - 1) >=0 && (y = j + 1) < M[0].length){
            num ++;
            sum += M[x][y];
        }
        if((y = j - 1) >=0){
            num ++;
            sum += M[i][y];
        }
        if((y = j + 1) < M[0].length){
            num ++;
            sum += M[x][y];
        }
        if((x = i + 1) < M.length && (y = j - 1) >=0){
            num ++;
            sum += M[x][y];
        }
        if((x = i + 1) < M.length){
            num ++;
            sum += M[x][j];
        }
        if((x = i + 1) < M.length && (y = j + 1) < M[0].length){
            num ++;
            sum += M[x][y];
        }
        return sum / num;
    }
}
