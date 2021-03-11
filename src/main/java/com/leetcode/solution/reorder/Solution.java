package com.leetcode.solution.reorder;

public class Solution {
    public void reorderList(ListNode head) {

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        if (len < 3) {
            return;
        }


        int i = 0;
        ListNode prev = null;
        node = head;
        while (i < (len + 1) / 2) {
            prev = node;
            node = node.next;
            i++;
        }
        prev.next = null;
        ListNode reversal = node;
        ListNode next = node.next;
        while (next != null) {
            ListNode nn = next.next;
            next.next = reversal;
            reversal = next;
            next = nn;
        }
        node.next = null;

        i = 0;
        node = head;



        while (node != null) {
            next = node.next;
            if(reversal != null){
                ListNode rNext = reversal.next;
                node.next = reversal;
                reversal.next = next;
                reversal = rNext;
            }
            node = next;
        }
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
//        ListNode g = new ListNode(7);
//        ListNode h = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
//        f.next = g;
//        g.next = h;


        new Solution().reorderList(a);
    }
}
