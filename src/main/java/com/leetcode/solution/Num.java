package com.leetcode.solution;

public class Num {
    public static void main(String[] args) {
        for(int n = 1; n <= 1000; n ++){
            String a = printNum(n);
            String b = getNum(n);
            System.out.println(a + "  " + b + "  " + a.equals(b));
        }
    }

    public static String getNum(int n){
        String str = Integer.toBinaryString(n + 1);
        String res = str.substring(1).replace("1", "2").replace("0", "1");
        return res;
    }

    public static String printNum(int n){
        if(n < 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0){

            if((n&1) == 0 ){
                sb.append(2);
            }else{
                sb.append(1);
            }
            n = (n - 1) >> 1;
        }
        return sb.reverse().toString();
    }
}
