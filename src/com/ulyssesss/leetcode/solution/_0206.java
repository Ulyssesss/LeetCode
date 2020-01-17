package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class _0206 {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public ListNode _reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = _reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
