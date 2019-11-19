package com.ulyssesss.leetcode;

import com.ulyssesss.leetcode.common.ListNode;
import com.ulyssesss.leetcode.solution._0002;

public class Test {
    public static void main(String[] args) {
        ListNode node1 = ListNode.createListNode(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1);
        ListNode node2 = ListNode.createListNode(5,6,4);
        ListNode result = new _0002().addTwoNumbers(node1, node2);
        System.out.println(result.toString());
    }
}
