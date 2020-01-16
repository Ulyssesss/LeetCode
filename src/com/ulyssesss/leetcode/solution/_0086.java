package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

/**
 * 86. 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 */
public class _0086 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode smallCurrent = smallHead;
        ListNode bigCurrent = bigHead;
        while (head != null) {
            if (head.val < x) {
                smallCurrent.next = head;
                smallCurrent = smallCurrent.next;
            } else {
                bigCurrent.next = head;
                bigCurrent = bigCurrent.next;
            }
            head = head.next;
        }
        smallCurrent.next = bigHead.next;
        bigCurrent.next = null;
        return smallHead.next;
    }
}
