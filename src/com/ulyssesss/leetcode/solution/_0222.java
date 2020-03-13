package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 */
public class _0222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            root = queue.remove();
            result++;
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return result;
    }

    public int _countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return _countNodes(root.left) + _countNodes(root.right) + 1;
    }

    public int __countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            return __countNodes(root.right) + (int) Math.pow(2, leftLevel);
        } else {
            return __countNodes(root.left) + (int) Math.pow(2, rightLevel);
        }
    }

    private int countLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(countLevel(node.left), countLevel(node.right)) + 1;
    }

}
