package com.leetcode.solution.q1238;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    private HashSet<Integer> set = new HashSet<>();

    public List<Integer> circularPermutation(int n, int start) {
        set.add(start);
        List<Integer> list = new ArrayList<>();
        fillNext(start, n, list);
        return list;
    }

    private boolean fillNext(int num, int n, List<Integer> list){
        List<Integer> numbers = getNumbers(num, n);
        if(numbers.isEmpty()){
            list.remove(list.size() - 1);
            return false;
        }
        if(list.size() == 1 << n){
            return true;
        }
        for(int next : numbers){
            list.add(next);
            set.add(next);
            if(fillNext(num, n, list)){
                break;
            }
        }
        return false;
    }


    public List<Integer> getNumbers(int num, int n){
        int mask = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            int r = 0;
            if(num >= mask){
                r = num ^ mask;
            } else {
                r = num | mask;
            }
            if(!set.contains(r)){
                res.add(r);
            }
            mask = mask << 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.getNumbers(4, 4));
        System.out.println(solution.circularPermutation(2, 3));
    }

}
