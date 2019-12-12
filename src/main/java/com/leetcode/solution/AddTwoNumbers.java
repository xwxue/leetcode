package com.leetcode.solution;
/*
*
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以0开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

* */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int c =0;
        int d= 0;
        while (l1 != null || l2 != null){
            int a = 0;
            if(l1!=null){
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if(l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            c = a + b + d;
            node.val = c % 10;
            d = c / 10;
            if(l1 != null || l2 != null){
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        if(c > 9){
            node.next = new ListNode(c / 10);
        }else{
            node.val = c;
        }


        return head;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}