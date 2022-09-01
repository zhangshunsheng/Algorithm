package com.example.demo_practise.algorithm.LCHOT100;

import com.example.demo_practise.algorithm.utilEntity.ListNode;

import java.util.List;

/**
 * ClassName: M_LC019_DelLinkReciprocalNNode
 * Description:
 * date: 2022/7/13 16:43
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC019_DelLinkReciprocalNNode {

    /**
     * 删除链表倒数的第n个节点
     * @param head
     * @param n
     * @return 返回头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        n--;
        while (n > 0) {
            if(first.next != null) {
                first = first.next;
                n--;
            } else {
                return null;
            }
        }
        ListNode after = new ListNode();
        after.next = head;
        ListNode tail = after;
        while (first.next != null) {
            after = after.next;
            first = first.next;
        }
        after.next = after.next.next;
        return  tail.next;
    }
}
