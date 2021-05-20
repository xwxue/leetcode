package com.leetcode.solution.q1209;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        Stack<Integer> countStack = new Stack<>();
        Character prev = null;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            if(prev == null) {
                prev = c;
                count ++;
            } else if(c == prev){
                count ++;
                if(count == k) {
                    for(int j = 0; j < k; j ++) {
                        stack.pop();
                    }
                    if(!stack.isEmpty()) {
                        prev = stack.peek();
                        count = countStack.pop();
                    } else {
                        prev = null;
                        count = 0;
                    }

                }
            } else {
                prev = c;
                countStack.push(count);
                count = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "pbbcggttciiippooaais";
        System.out.println(new Solution().removeDuplicates(s, 2));

    }
}
