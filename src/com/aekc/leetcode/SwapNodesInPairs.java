package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-26 下午5:13
 */
public class SwapNodesInPairs {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode front = head;
        ListNode listNode = null;
        while(front != null && front.next != null) {
            ListNode temp = front.next.next;
            if(listNode == null) {
                ListNode p = front.next;
                p.next = front;
                front.next = temp;
                head = p;
            } else {
                ListNode p = front.next;
                listNode.next = p;
                p.next = front;
                front.next = temp;
            }
            listNode = front;
            front = front.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode head = swapNodesInPairs.new ListNode(1);


        head = swapNodesInPairs.swapPairs(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
