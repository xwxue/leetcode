package com.leetcode.solution.q0109;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    public TreeNode sortedListToBST(ListNode head) {

        return make(head, null);
    }

    public TreeNode make(ListNode head, ListNode end) {
        if(head == null || head == end) {
            return null;
        }
        if(head.next == end) {
            return new TreeNode(head.val);
        }

        ListNode midListNode = mid(head, end);
        TreeNode midTreeNode = new TreeNode(midListNode.val);
        midTreeNode.left = make(head, midListNode);
        midTreeNode.right = make(midListNode.next, end);
        return midTreeNode;
    }

    private ListNode mid(ListNode head, ListNode end) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null  && fast.next != null && fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        ListNode head = new ListNode();
        ListNode h = head;
        for (int num : nums) {
            h.next = new ListNode(num);
            h = h.next;
        }
        TreeNode node = new Solution().sortedListToBST(head.next);
        System.out.println(node);
    }
}
