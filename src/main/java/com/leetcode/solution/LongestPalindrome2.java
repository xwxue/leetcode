package com.leetcode.solution;

public class LongestPalindrome2 {
    public String longestPalindrome(String s) {
        boolean t[][] = new boolean[s.length()][s.length()];
        int start = 0;
        int end = -1;
        int a = 0;
        int b = 0;
        for (a = 0; a < t.length; a++) {
            t[a][a] = true;
        }
        int tmpA;
        int tmpB;
        for (a = 0; a < t.length; a++) {
            for (b = 0; b < t.length; b++) {
                if (t[a][b]) {
                    tmpA = a - 1;
                    tmpB = b + 1;
                    if (tmpA >= 0 && tmpB < t.length && s.charAt(tmpA) == s.charAt(tmpB)) {
                        t[tmpA][tmpB] = true;
                        if (tmpB - tmpA > end - start) {
                            start = tmpA;
                            end = tmpB;
                        }
                    } else {
                        if (b - a > end - start) {
                            start = a;
                            end = b;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = new LongestPalindrome2().longestPalindrome("cc");
        System.out.println(s);
    }
}
