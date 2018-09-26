package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-26 下午7:58
 */
public class ReverseNodesInKGroup {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Auxiliary {
        ListNode start;
        ListNode end;

        Auxiliary(ListNode start, ListNode end) {
            this.start = start;
            this.end = end;
        }
    }

    public Auxiliary reverseKGroup(ListNode front) {
        ListNode head = new ListNode(0);
        head.next = front;

        while(front != null && front.next != null) {
            ListNode temp = front.next.next;
            ListNode p = front.next;

            ListNode q = head.next;
            head.next = p;
            p.next = q;

            front.next = temp;
        }
        return new Auxiliary(head.next, front);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode front = head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode end;
        int sum = k;
        while(front != null && front.next != null) {
            while(sum-- > 1) {
                front = front.next;
                if(front == null) {
                    return head;
                }
            }
            end = front.next;
            front.next = null;
            Auxiliary auxiliary = reverseKGroup(start.next);
            if(start.next == head) {
                head = auxiliary.start;
            }
            start.next = auxiliary.start;
            auxiliary.end.next = end;
            start = auxiliary.end;
            front = end;
            sum = k;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode head = reverseNodesInKGroup.new ListNode(1);
        ListNode listNode = reverseNodesInKGroup.new ListNode(2);
        head.next = listNode;
        listNode.next = reverseNodesInKGroup.new ListNode(3);
        listNode = listNode.next;
        listNode.next = reverseNodesInKGroup.new ListNode(4);
        listNode = listNode.next;
        listNode.next = reverseNodesInKGroup.new ListNode(5);
        head = reverseNodesInKGroup.reverseKGroup(head, 3);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
