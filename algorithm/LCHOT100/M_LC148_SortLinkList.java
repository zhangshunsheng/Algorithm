package com.example.demo_practise.algorithm.LCHOT100;

import com.example.demo_practise.algorithm.utilEntity.ListNode;

/**
 * ClassName: M_LC148_SortLinkList
 * Description:
 * date: 2022/7/29 15:04
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC148_SortLinkList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        return mergeSortLinkList(head);
    }

    public ListNode mergeSortLinkList(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        ListNode midNext = slow.next;
        slow.next = null;
        ListNode first = mergeSortLinkList(head);
        ListNode after = mergeSortLinkList(midNext);
        return merge(first, after);

    }
    public ListNode merge(ListNode first, ListNode after) {
        ListNode temp = new ListNode();
        ListNode add = temp;
        while(first != null && after != null) {
            if(first.val < after.val) {
                add.next = first;
                first = first.next;
            } else {
                add.next = after;
                after = after.next;
            }
            add = add.next;
        }
        if(first == null) {
            add.next = after;
            return temp.next;
        }
        add.next = first;
        return temp.next;
    }
}
