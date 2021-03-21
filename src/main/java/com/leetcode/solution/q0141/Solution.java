package com.leetcode.solution.q0141;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode n = head;
        ListNode nn = head.next;
        while (n != null && nn != null) {
            if(n == nn) {
                return true;
            }
            n = n.next;
            nn = nn.next != null ? nn.next.next : null;
        }
        return false;
    }
}
