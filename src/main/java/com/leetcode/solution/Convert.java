package com.leetcode.solution;

/*
* 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
*/
public class Convert {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int space = (numRows - 1) * 2;  //垂直行的间距
        int next = 0;   //表示所取s中字符的下标
        int row = 1;    //表示当前再取的z图形中的第row行数据
        int rowNum = 0; //表示第row行中的第rowNum个字母
        for (int i = 0; i < s.length(); i++) {
            if (row < numRows) {
                if(row == 1){
                    next = rowNum * space;
                } else {
                    if (rowNum % 2 == 1) {
                        next += (numRows - row) * 2;
                    } else {
                        next += space - (numRows - row) * 2;
                    }
                }

                if (next < s.length()) {
                    sb.append(s.charAt(next));
                    rowNum++;
                } else {
                    row++;
                    rowNum = 0;
                    next = row - 1;
                    if(next < s.length()){
                        sb.append(s.charAt(next));
                        rowNum++;
                    }
                }
            } else if(row == numRows){
                next = next + space;
                if (next < s.length()) {
                    sb.append(s.charAt(next));
                    rowNum++;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //LDREOEIIECIHNTSG
        //LCIRETOESIIGEDHN
        String s = new Convert().convert("LEETCODEISHIRING", 4);
        System.out.println(s);
        System.out.println("LDREOEIIECIHNTSG");
        System.out.println("LDREOEIIECIHNTSG".equals(s));

        s = new Convert().convert("LEETCODEISHIRING", 3);
        System.out.println(s);
        System.out.println("LCIRETOESIIGEDHN");
        System.out.println("LCIRETOESIIGEDHN".equals(s));

        s = new Convert().convert("AB", 1);
        System.out.println(s);
        System.out.println("AB");
        System.out.println("AB".equals(s));
    }
}
