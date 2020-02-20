package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class _0103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        Stack<TreeNode> temp;
        current.push(root);
        List<Integer> items;
        boolean leftToRight = true;
        while (!current.isEmpty()) {
            items = new ArrayList<>();
            do {
                root = current.pop();
                items.add(root.val);
                if (leftToRight) {
                    if (root.left != null) {
                        next.push(root.left);
                    }
                    if (root.right != null) {
                        next.push(root.right);
                    }
                } else {
                    if (root.right != null) {
                        next.push(root.right);
                    }
                    if (root.left != null) {
                        next.push(root.left);
                    }
                }
            } while (!current.isEmpty());
            leftToRight = !leftToRight;
            list.add(items);
            temp = current;
            current = next;
            next = temp;
        }
        return list;
    }
}
