package com.aekc.leetcode;

public class RemoveNthNodeFromEndOfList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode listNode = head;
        while(listNode != null) {
            ++k;
            listNode = listNode.next;
        }
        int p = 0;
        ListNode front = null;
        ListNode behind = head;
        while(p++ != k - n && behind.next != null) {
            front = behind;
            behind = behind.next;
        }
        if(front != null) {
            front.next = behind.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode head = removeNthNodeFromEndOfList.new ListNode(1);

        head = removeNthNodeFromEndOfList.removeNthFromEnd(head, 1);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
