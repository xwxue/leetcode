package com.leetcode.solution;

public class MyAtoi {
    public int myAtoi(String str) {
        long res = 0;
        boolean positive = true;
        boolean first = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(first){
                if(' ' == c){
                    continue;
                } else if('-' == c){
                    positive = false;
                    first = false;
                } else if('+' == c){
                    first = false;
                } else if(c >= '0' && c <= '9'){
                    res = c - '0';
                    first = false;
                } else {
                    return 0;
                }
            }else {
                if(c >= '0' && c <= '9'){
                    res = res * 10 + (c - '0');
                    if(res > Integer.MAX_VALUE){
                        if(positive){
                            return Integer.MAX_VALUE;
                        }else{
                            return Integer.MIN_VALUE;
                        }
                    }
                }else{
                    break;
                }
            }

        }
        return positive ? (int)res : -(int)(res);
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi(""));
    }
}
