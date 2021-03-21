package com.leetcode.solution;

public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        int allArea = 0;
        int x, y;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = getArea(grid[i][j]);
                if ((x = i - 1) > -1) {
                    area -= Math.min(grid[i][j], grid[x][j]);
                }
                if ((x = i + 1) < grid.length) {
                    area -= Math.min(grid[i][j], grid[x][j]);
                }
                if ((y = j - 1) > -1) {
                    area -= Math.min(grid[i][j], grid[i][y]);
                }
                if ((y = j + 1) < grid[i].length) {
                    area -= Math.min(grid[i][j], grid[i][y]);
                }
                allArea += area;
            }
        }
        return allArea;
    }

    public int getArea(int i) {
        if (i == 0) {
            return 0;
        }
        return 6 * i - 2 * (i - 1);
    }

    public static void main(String[] args) {
        System.out.println(new SurfaceArea().surfaceArea(new int[][]{{2}}));
        System.out.println(new SurfaceArea().surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(new SurfaceArea().surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println(new SurfaceArea().surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
