package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 2019-02-13 13:22
 */
public class ReverseLinkedListTwo {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    /*public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head.next;
        ListNode temp = head;
        ListNode front = null;
        ListNode after = null;
        int k = 2;
        if(m == 1) {
            front = head;
        }
        while(node != null) {
            if(k == m) {
                front = temp;
            }
            if(k == n) {
                after = temp;
                break;
            }
            temp = node;
            node = node.next;
            k++;
        }
        if(front != null && after != null) {
            if(m == 1 && n == 2) {
                ListNode temp1 = after.next;
                front.next = after.next.next;
                temp1.next = front;
                head = temp1;
            } else if(m == 1) {
                ListNode temp1 = front.next;
                ListNode temp2 = after.next;
                front.next = after.next.next;
                after.next = front;
                temp2.next = temp1;
                head = temp2;
            } else if(n - m == 1) {
                ListNode temp2 = after.next.next;
                front.next = after.next;
                front.next.next = after;
                after.next = temp2;
            } else {
                ListNode temp1 = front.next.next;
                ListNode temp2 = after.next.next;
                ListNode temp3 = front.next;
                front.next = after.next;
                after.next = temp3;
                front.next.next = temp1;
                after.next.next = temp2;
            }
        }
        return head;
    }*/

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        ListNode temp = head;
        ListNode front = head;
        //ListNode after = null;
        int k = 1;
        while(node != null) {
            if(k == m - 1) {
                front = node;
            }
            if(k > m && m == 1) {
                ListNode ln = node.next;
                node.next = head;
                temp.next = ln;
                head = node;
                node = temp;
            } else if(k > m) {
                ListNode ln = front.next;
                front.next = node;
                temp.next = node.next;
                node.next = ln;
                node = temp;
            }
            if(k == n) {
                //after = node;
                break;
            }
            temp = node;
            node = node.next;
            k++;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListTwo reverseLinkedListTwo = new ReverseLinkedListTwo();
        ListNode head = reverseLinkedListTwo.new ListNode(1);
        ListNode node1 = reverseLinkedListTwo.new ListNode(2);
        head.next = node1;
        ListNode node2 = reverseLinkedListTwo.new ListNode(3);
        node1.next = node2;
        ListNode node3 = reverseLinkedListTwo.new ListNode(4);
        node2.next = node3;
        ListNode node4 = reverseLinkedListTwo.new ListNode(5);
        node3.next = node4;
        ListNode node5 = reverseLinkedListTwo.new ListNode(6);
        node4.next = node5;
        head = reverseLinkedListTwo.reverseBetween(head, 2, 2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
