package com.leetcode.solution.q0703;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> queue;

    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        queue.add(val);
        if(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));   // return 4
        System.out.println(k.add(5));   // return 5
        System.out.println(k.add(10));  // return 5
        System.out.println(k.add(9));   // return 8
        System.out.println(k.add(4));   // return 8

    }
}
