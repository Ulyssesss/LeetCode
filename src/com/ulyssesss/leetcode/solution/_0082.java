package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 *
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */
public class _0082 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode previous = null;
        ListNode next;
        ListNode temp = dummy;
        while (head != null) {
            next = head.next;
            if ((previous == null || previous.val != head.val) && (next == null || next.val != head.val)) {
                temp.next = head;
                temp = temp.next;
                temp.next = null;
            }
            previous = head;
            head = next;
        }
        return dummy.next;
    }
}
