package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-11 下午6:04
 */
public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode sumListNode = null;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            int k = l1.val + l2.val;
            if (carry) {
                k = k + 1;
                carry = false;
            }
            if (k >= 10) {
                carry = true;
                k = k - 10;
            }
            if (sumListNode != null) {
                sumListNode.next = new ListNode(k);
                sumListNode = sumListNode.next;
            } else {
                sumListNode = new ListNode(k);
                head = sumListNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node = l1 == null ? l2 : l1;
        while (node != null) {
            sumListNode.next = node;
            if (carry) {
                carry = false;
                if (++sumListNode.next.val >= 10) {
                    sumListNode.next.val = 0;
                    carry = true;
                }
            }
            node = node.next;
            sumListNode = sumListNode.next;
        }
        if (carry) {
            sumListNode.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l1 = addTwoNumbers.new ListNode(9);
        ListNode l2 = addTwoNumbers.new ListNode(9);

        ListNode head1 = l1;
        ListNode head2 = l2;


        ListNode listNode = addTwoNumbers.addTwoNumbers(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
