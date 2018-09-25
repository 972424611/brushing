package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-25 下午8:11
 */
public class MergeTwoSortedLists {

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

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode head1 = mergeTwoSortedLists.new ListNode(5);

        ListNode head2 = mergeTwoSortedLists.new ListNode(1);
        ListNode l2 = mergeTwoSortedLists.new ListNode(3);
        head2.next = l2;
        l2.next = mergeTwoSortedLists.new ListNode(4);

        ListNode head = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
