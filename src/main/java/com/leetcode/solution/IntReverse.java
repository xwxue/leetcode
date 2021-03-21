package com.leetcode.solution;

public class IntReverse {
    public int reverse(int x) {
        boolean positive;
        if(x > 0){
            positive = true;
        }else{
            x = -x;
            positive = false;
        }
        long res = 0;
        while (x > 0){
            res = res * 10 + (x % 10);
            x /= 10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return positive ? (int)res : -(int)res;
    }

    public static void main(String[] args) {
        System.out.println(new IntReverse().reverse(-129));
    }
}
