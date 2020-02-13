package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class _0104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int _maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int max = 0;
        int current;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            root = pair.getKey();
            current = pair.getValue();
            max = Math.max(max, current);
            if (root.left != null) {
                stack.push(new Pair<>(root.left, current + 1));
            }
            if (root.right != null) {
                stack.push(new Pair<>(root.right, current + 1));
            }
        }
        return max;
    }
}
