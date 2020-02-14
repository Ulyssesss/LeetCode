package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class _0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            levelOrderHelper(list, Collections.singletonList(root));
        }
        return list;
    }

    private void levelOrderHelper(List<List<Integer>> list, List<TreeNode> nodes) {
        if (nodes.size() == 0) {
            return;
        }
        List<Integer> values = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }
        list.add(values);
        levelOrderHelper(list, children);
    }

    public List<List<Integer>> _levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> values;
        TreeNode current;
        int size;
        while (!queue.isEmpty()) {
            values = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.removeFirst();
                values.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            list.add(values);
        }
        return list;
    }
}
