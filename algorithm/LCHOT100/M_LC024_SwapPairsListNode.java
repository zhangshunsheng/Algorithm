package com.example.demo_practise.algorithm.LCHOT100;

import com.example.demo_practise.algorithm.utilEntity.ListNode;

/**
 * ClassName: M_LC024_SwapPairsListNode
 * Description:
 * date: 2022/7/21 15:12
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC024_SwapPairsListNode {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     */

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        int count = 2;
        ListNode tail = head.next;
        ListNode prepreNode = null;
        ListNode preNode = head;
        ListNode indexNode = head.next;
        while(indexNode != null) {
            if(count % 2 == 0) {
                preNode.next = indexNode.next;
                indexNode.next = preNode;
                if(prepreNode != null) {
                    prepreNode.next = indexNode;
                }
                prepreNode = indexNode;
                indexNode = preNode.next;
                count++;
            } else {
                prepreNode = preNode;
                preNode = indexNode;
                indexNode = indexNode.next;
                count++;
            }
        }
        return tail;
    }
}
