package com.ulyssesss.leetcode;

import com.ulyssesss.leetcode.common.ListNode;
import com.ulyssesss.leetcode.solution._0083;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;

        ListNode result = new _0083().deleteDuplicates(l1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }



    }
}
