package com.leetcode.solution.q1848;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode h = head;
        ListNode nHead = new ListNode(-1);
        while (h != null) {
            ListNode tmp = h.next;
            ListNode headNext = nHead.next;
            nHead.next = h;
            h.next = headNext;
            h = tmp;
        }
        return nHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode head = new ListNode(-1);
        ListNode h = head;
        for (int num : nums) {
            h.next = new ListNode(num);
            h = h.next;
        }
        head = new Solution().reverseList(head.next);
        System.out.println(head);
    }
}
