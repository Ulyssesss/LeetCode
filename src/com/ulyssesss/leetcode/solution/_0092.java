package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class _0092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next;
        ListNode previous = null;
        ListNode firstReverse = null;
        int i = 1;
        while (head != null) {
            next = head.next;
            if (i >= m && i <= n) {
                if (firstReverse == null) {
                    firstReverse = head;
                }
                head.next = previous;
                previous = head;
                current.next = head;
                if (i == n) {
                    current = firstReverse;
                }
            } else {
                if (i == n + 1) {
                    current.next = head;
                    break;
                }
                current = current.next;
            }
            head = next;
            i++;
        }
        return dummy.next;
    }
}
