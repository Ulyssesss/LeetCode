package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class _0113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        collectPath(paths, new ArrayList<>(), root, sum);
        return paths;
    }

    private void collectPath(List<List<Integer>> paths, List<Integer> temp, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        temp.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            paths.add(new ArrayList<>(temp));
        }

        collectPath(paths, temp, node.left, sum);
        collectPath(paths, temp, node.right, sum);
        temp.remove(temp.size() - 1);
    }
}
