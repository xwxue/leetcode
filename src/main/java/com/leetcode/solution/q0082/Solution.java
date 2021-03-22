package com.leetcode.solution.q0082;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode nHead = new ListNode(-1, head);
        ListNode tail = nHead;
        ListNode h = head;
        while (h != null) {
            if(h.next == null || h.val != h.next.val) {
                tail.next = h;
                tail = h;
                h = h.next;
            } else {
                ListNode s = h.next;
                while (s != null && s.val == h.val) {
                    s = s.next;
                }
                h = s;
            }
        }
        tail.next = null;

        return nHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        ListNode head = new ListNode();
        ListNode h = head;
        for (int num : nums) {
            h.next = new ListNode(num);
            h = h.next;
        }
        head = new Solution().deleteDuplicates(head.next);
        System.out.println(head);
    }
}
