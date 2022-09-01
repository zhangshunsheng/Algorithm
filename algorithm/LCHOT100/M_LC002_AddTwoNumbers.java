package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: M_LC002_AddTwoNumbers
 * Description: 一次通过
 * date: 2022/7/12 10:16
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC002_AddTwoNumbers {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cap = 0;
        ListNode head = new ListNode();
        ListNode res = head;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode();
            temp.val = (l1.val + l2.val + cap) % 10;
            cap = (l1.val + l2.val + cap) / 10;
            head.next = temp;
            head = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode temp = new ListNode();
            temp.val = (l1.val + cap) % 10;
            cap = (l1.val + cap) / 10;
            head.next = temp;
            head = temp;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode temp = new ListNode();
            temp.val = (l2.val + cap) % 10;
            cap = (l2.val + cap) / 10;
            head.next = temp;
            head = temp;
            l2 = l2.next;
        }
        if(cap != 0) {
            ListNode temp = new ListNode();
            temp.val = cap;
            head.next = temp;
        }
        return res.next;
    }
}
