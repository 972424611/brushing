package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-25 下午9:27
 */
public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode temp = l1;
        while(l2 != null) {
            while(l1 != null && l2.val > l1.val) {
                temp = l1;
                l1 = l1.next;
            }
            if(l1 == head) {
                ListNode listNode = new ListNode(l2.val);
                listNode.next = head;
                head = listNode;
                l1 = head;
            } else {
                if(l1 != null) {
                    ListNode listNode = new ListNode(l2.val);
                    temp.next = listNode;
                    listNode.next = l1;
                    temp = listNode;
                } else {
                    temp.next = new ListNode(l2.val);
                    l1 = temp.next;
                }
            }
            l2 = l2.next;
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length < 2) {
            return lists[0];
        }
        ListNode head = lists[0];
        for(int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public static void main(String[] args) {

    }


}
