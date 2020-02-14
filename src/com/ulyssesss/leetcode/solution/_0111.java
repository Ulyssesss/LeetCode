package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class _0111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    public int _minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));


        Pair<TreeNode, Integer> pair;
        int depth = 0;
        while (!queue.isEmpty()) {
            pair = queue.removeFirst();
            root = pair.getKey();
            depth = pair.getValue();
            if (root.left == null && root.right == null) {
                break;
            }
            if (root.left != null) {
                queue.add(new Pair<>(root.left, depth + 1));
            }
            if (root.right != null) {
                queue.add(new Pair<>(root.right, depth + 1));
            }
        }
        return depth;
    }
}
