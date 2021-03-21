package com.leetcode.solution;

public class GenerateMatrix {
    enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int i = 0;
        int j = 0;
        int a = 1;
        Direction d = Direction.RIGHT;
        while (a <= n * n) {
            matrix[i][j] = a++;
            switch (d) {
                case RIGHT:
                    if (++j >= n || matrix[i][j] != 0) {
                        d = Direction.DOWN;
                        j--;
                        i++;
                    }
                    break;
                case UP:
                    if (--i < 0 || matrix[i][j] != 0) {
                        d = Direction.RIGHT;
                        i++;
                        j++;
                    }
                    break;
                case DOWN: {
                    if (++i >= n || matrix[i][j] != 0) {
                        d = Direction.LEFT;
                        i--;
                        j--;
                    }
                    break;
                }
                case LEFT:
                    if(--j < 0 || matrix[i][j] != 0){
                        d = Direction.UP;
                        j++;
                        i--;
                    }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new GenerateMatrix().generateMatrix(3);
        for(int i=0;i<matrix.length;i++){
            for(int j = 0; j<matrix[i].length;j++){
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
