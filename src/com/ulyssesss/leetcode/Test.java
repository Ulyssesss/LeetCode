package com.ulyssesss.leetcode;

import com.ulyssesss.leetcode.common.ListNode;
import com.ulyssesss.leetcode.solution._0092;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = new _0092().reverseBetween(l1, 1, 1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }



    }
}
