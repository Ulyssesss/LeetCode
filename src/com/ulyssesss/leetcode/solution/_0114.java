package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class _0114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                findMostRight(root.left).right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    private TreeNode findMostRight(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
