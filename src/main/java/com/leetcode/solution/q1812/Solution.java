package com.leetcode.solution.q1812;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
    int[] pointMinJump;
    public int minJump(int[] jump) {
        pointMinJump = new int[jump.length];
        Arrays.fill(pointMinJump, Integer.MAX_VALUE);
        int oneMin = jump.length - 1;
        for(int i = jump.length - 1; i  >=0; i --) {
            if(i + jump[i] >= jump.length) {
                pointMinJump[i] = 1;
                oneMin = i;
            }
        }
        if(pointMinJump[0] == 1) {
            return 1;
        }
        for(int i = oneMin + 1; i < jump.length; i ++) {
            if(pointMinJump[i] == Integer.MAX_VALUE) {
                pointMinJump[i] = 2;
            }
        }
//        for(int i = oneMin - 1; i >=0 ;i --) {
            dfs(jump,  0, 0, jump.length);
//        }
        return pointMinJump[0];
    }

    private int dfs(int[] jump, int currentPoint, int step, int maxStep) {
        if(step >= maxStep) {
            return maxStep;
        }
        if(pointMinJump[currentPoint] != Integer.MAX_VALUE && pointMinJump[currentPoint] != -1) {
            return pointMinJump[currentPoint];
        }
        pointMinJump[currentPoint] = -1;
        int min = dfs(jump, currentPoint + jump[currentPoint],  0 , maxStep);
//        if(min > 1)
        for(int i = 0; i < currentPoint; i++) {
            if(pointMinJump[i] == -1) {
                continue;
            }
            min = Math.min(min, dfs(jump, i,  step + 1, min ));
        }

        pointMinJump[currentPoint] = min + 1;
//        for(int i =  0; i < currentPoint; i ++) {
//            if(pointMinJump[i] == -1) {
//                pointMinJump[i] = Integer.MAX_VALUE;
//            }
//        }

        return pointMinJump[currentPoint];
    }


    public static void main(String[] args) throws Exception {
        String s = IOUtils.toString(new FileInputStream("C:\\Users\\10125\\Desktop\\array.txt"));
        JSONArray arr = JSONArray.parseArray(s);
        int[] jump = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            jump[i] = arr.getInteger(i);
        }
//        int[] jump = {3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7,5,1,1};
        System.out.println(new Solution().minJump(jump));
    }
}
