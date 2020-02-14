package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

/**
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class _0404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumHelper(root, false);
    }

    private int sumHelper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        int val = 0;
        if (isLeft && node.left == null && node.right == null) {
            val = node.val;
        }
        return val + sumHelper(node.left, true) + sumHelper(node.right, false);
    }
}
