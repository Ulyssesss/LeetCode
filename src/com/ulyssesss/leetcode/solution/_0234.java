package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class _0234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode current = head;
        List<ListNode> nodes = new ArrayList<>();
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        int size = nodes.size();
        for (int i = 0; i < size / 2; i++) {
            if (nodes.get(i).val != nodes.get(size - i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public boolean _isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverse(slow.next);
        slow = head;
        fast = reverse;
        boolean result = true;
        while (fast != null) {
            if (slow.val != fast.val) {
                result = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        //恢复后半段链表，提交时发现不恢复也能通过全部测试用例
        reverse(reverse);
        return result;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode previous = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return previous;
    }
}
