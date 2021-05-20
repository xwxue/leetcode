package com.leetcode.solution.q2002;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;

public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        if(word1.equals(word2)) {
            return 0;
        }

        int a = -1;
        int b = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                a = i;
            } else if(words[i].equals(word2)) {
                b = i;
            }
            if(a < 0 || b < 0) {
                continue;
            }
            min = Math.min(Math.abs(a - b), min);
            if(min == 1) {
                return min;
            }
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        String s = IOUtils.toString(new FileInputStream("C:\\Users\\xuewei01\\Desktop\\json.txt"));
        JSONArray jsonArray = JSON.parseArray(s);

        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            arr[i] = jsonArray.getString(i);
        }
        System.out.println(new Solution().findClosest(arr, "bx", "rx"));
    }
}
