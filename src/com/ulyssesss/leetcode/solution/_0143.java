package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0 → L1 → … → Ln-1 → Ln ，
 * 将其重新排列后变为： L0 → Ln → L1 → Ln-1 → L2→ Ln -2 → …
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 *
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 */
public class _0143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = reverse(splitAndFindMidNode(head));
        ListNode headNext;
        ListNode midNext;
        while (mid != null) {
            headNext = head.next;
            midNext = mid.next;
            head.next = mid;
            mid.next = headNext;
            head = headNext;
            mid = midNext;
        }
    }

    private ListNode splitAndFindMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode headNext;
        while (head != null) {
            headNext = head.next;
            head.next = previous;
            previous = head;
            head = headNext;
        }
        return previous;
    }
}
