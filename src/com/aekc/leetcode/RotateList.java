package com.aekc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Twilight
 * @date 18-10-18 下午6:49
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        while(head.next != null) {
            map.put(head.next.hashCode(), head);
            head = head.next;
        }
        map.put(-1, head);
        k = k % map.size();
        while(k > 0) {
            ListNode temp = first.next;
            ListNode listNode = map.get(-1);
            first.next = listNode;
            listNode.next = temp;
            map.put(temp.hashCode(), listNode);
            temp = map.get(listNode.hashCode());
            temp.next = null;
            map.put(-1, temp);
            k--;
        }
        return first.next;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new RotateList().new ListNode(1);
        ListNode temp = new RotateList().new ListNode(2);
        head.next = temp;
        ListNode temp2 = new RotateList().new ListNode(3);
        temp.next = temp2;

        head = rotateList.rotateRight(head, 1);
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }

    }
}
