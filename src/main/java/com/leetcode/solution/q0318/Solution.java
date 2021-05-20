package com.leetcode.solution.q0318;

public class Solution {
    public int maxProduct(String[] words) {
        int[] bitmaps = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bitmaps[i] = makeBitmap(words[i]);
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((bitmaps[i] & bitmaps[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private int makeBitmap(String s) {
        int bitmap = 0;
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            bitmap |= (1 << (c - 'a'));
        }
        return bitmap;
    }

    public static void main(String[] args) {
        String[] arr =  {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(new Solution().maxProduct(arr));
    }
}
