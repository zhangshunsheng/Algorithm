package com.example.demo_practise.algorithm.LCHOT100;

import com.example.demo_practise.algorithm.utilEntity.ListNode;

/**
 * ClassName: S_LC141_CheckCycleListNode
 * Description:
 * date: 2022/7/21 15:23
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC141_CheckCycleListNode {
    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode first = head.next;
        ListNode after = head;
        while(first != null && first.next != null && after != first) {
            after = after.next;
            first = first.next.next;
        }
        if(first == after) {
            return true;
        }
        return false;
    }
}
