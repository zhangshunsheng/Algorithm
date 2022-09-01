package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: S_LC021_MergeTwoLinkLists
 * Description:
 * date: 2022/7/12 12:51
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC021_MergeTwoLinkLists {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode head = newList;

        while(list1 != null && list2 != null) {
            ListNode temp = new ListNode();
            if(list1.val < list2.val) {
                temp.val = list1.val;
                list1 = list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            newList.next = temp;
            newList = newList.next;
        }

        while(list1 != null) {
            ListNode temp = new ListNode();
            temp.val = list1.val;
            list1 = list1.next;
            newList.next = temp;
            newList = newList.next;
        }
        while(list2 != null) {
            ListNode temp = new ListNode();
            temp.val = list2.val;
            list2 = list2.next;
            newList.next = temp;
            newList = newList.next;
        }
        return head.next;
    }
}
