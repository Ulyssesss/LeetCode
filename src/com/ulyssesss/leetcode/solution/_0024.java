package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class _0024 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode first;
        ListNode second;
        while (current.next != null && current.next.next != null) {
            first = current.next;
            second = first.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return dummy.next;
    }
}
