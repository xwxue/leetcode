package com.leetcode.solution.q1894;

public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        ListNode slow = null;
        ListNode fast = head;
        int i = 0;
        while (fast != null) {
            i ++;
            if(i >= k) {
                if(slow == null) {
                    slow = head;
                } else {
                    slow = slow.next;
                }
            }
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;

        System.out.println(new Solution1().getKthFromEnd(l1, 9));
    }
}
