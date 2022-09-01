package com.example.demo_practise.algorithm.LCHOT100;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * ClassName: H_LC023_MergeNLinkList
 * Description:
 * date: 2022/7/13 15:11
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class H_LC023_MergeNLinkList {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     */

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 读出所有数据排序再放进链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> allData = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                allData.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        Collections.sort(allData);
        ListNode res = new ListNode();
        ListNode head = res;
        for (int i = 0; i < allData.size(); i++) {
            ListNode temp = new ListNode();
            res.next = temp;
        }
        return head.next;
    }

    /**
     * 归并合并
     * @param lists
     * @return
     */
    public ListNode mergeKListsByMerge(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeList(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        if(start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        return merge(mergeList(lists, start, mid), mergeList(lists, mid+1, end));
    }

    /**
     * 逐个合并
     * @param lists
     * @return
     */
    public ListNode mergeKListsByCycle(ListNode[] lists) {
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = merge(res, lists[i]);
        }
        return res;
    }

    public ListNode merge(ListNode start, ListNode end) {
        ListNode head = new ListNode();
        ListNode res = head;
        while (start != null && end != null) {
            if(start.val < end.val) {
                head.next = start;
                start = start.next;
                head = head.next;
            } else {
                head.next = end;
                end = end.next;
                head = head.next;
            }
        }
        head.next = start == null ? end : start;
        return res.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    /**
     * 使用优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        if(lists.length < 1) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                queue.offer(new Status(lists[i].val, lists[i]));
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode ptr = queue.poll().ptr;
            head.next = ptr;
            head = head.next;
            ptr = ptr.next;
            queue.offer(new Status(ptr.val, ptr));
        }
        return tail.next;
    }

}
