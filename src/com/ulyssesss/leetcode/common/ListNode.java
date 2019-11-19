package com.ulyssesss.leetcode.common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(int ... items) {
        ListNode result = null;
        ListNode preNode = null;
        for (int item : items) {
            ListNode node = new ListNode(item);
            if (result == null) {
                preNode = node;
                result = node;
            } else {
                preNode.next = node;
                preNode = node;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder result = new StringBuilder(String.valueOf(this.val));
        while (node.next != null) {
            node = node.next;
            result.append(",").append(String.valueOf(node.val));
        }
        return result.toString();
    }
}
