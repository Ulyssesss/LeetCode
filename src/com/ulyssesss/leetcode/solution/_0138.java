package com.ulyssesss.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 *
 * 示例 1：
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *
 * 示例 2：
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 *
 * 示例 3：
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 *
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 */
public class _0138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node newCurrent = dummy;
        Node oldCurrent = head;
        Map<Node, Node> nodeMap = new HashMap<>();
        while (oldCurrent != null) {
            newCurrent.next = new Node(oldCurrent.val);
            newCurrent = newCurrent.next;
            nodeMap.put(oldCurrent, newCurrent);
            oldCurrent = oldCurrent.next;
        }
        oldCurrent = head;
        while (oldCurrent != null) {
            if (oldCurrent.random != null) {
                nodeMap.get(oldCurrent).random = nodeMap.get(oldCurrent.random);
            }
            oldCurrent = oldCurrent.next;
        }
        return dummy.next;
    }

    private Map<Node, Node> nodeMap = new HashMap<>();

    private Node getCloneNode(Node node) {
        if (node == null) {
            return null;
        }
        Node cloneNode = nodeMap.get(node);
        if (cloneNode == null) {
            cloneNode = new Node(node.val);
            nodeMap.put(node, cloneNode);
        }
        return cloneNode;
    }

    public Node _copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node temp = getCloneNode(head);
        while (current != null) {
            temp.next = getCloneNode(current.next);
            temp.random = getCloneNode(current.random);
            current = current.next;
            temp = temp.next;
        }
        return getCloneNode(head);
    }

    public Node __copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        current = head;
        while (current != null) {
            current.next.random = (current.random != null) ? current.random.next : null;
            current = current.next.next;
        }
        Node oldList = head;
        Node newList = head.next;
        Node result = head.next;
        while (oldList != null) {
            oldList.next = oldList.next.next;
            newList.next = (newList.next != null) ? newList.next.next : null;
            oldList = oldList.next;
            newList = newList.next;
        }
        return result;
    }
}
