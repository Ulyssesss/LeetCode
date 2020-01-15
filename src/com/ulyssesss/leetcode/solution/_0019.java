package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class _0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        int toRemoveIndex = nodes.size() - n;
        if (toRemoveIndex == 0) {
            return head.next;
        } else {
            ListNode toRemoveNode = nodes.get(toRemoveIndex);
            ListNode previousNode = nodes.get(toRemoveIndex - 1);
            previousNode.next = toRemoveNode.next;
            return head;
        }
    }

    public ListNode _removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        while (n >= 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
