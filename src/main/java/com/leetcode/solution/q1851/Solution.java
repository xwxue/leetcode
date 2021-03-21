package com.leetcode.solution.q1851;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        int len = 0;
        ListNode h = head;
        while (h != null) {
            len ++;
            h = h.next;
        }
        int n = len - k;
        if(n < 0) {
            return null;
        }
        h = head;
        while (n -- > 0) {
            h = h.next;
        }
        return h;
    }
}
