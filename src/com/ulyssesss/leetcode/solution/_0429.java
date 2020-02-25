package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.Node;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *         1
 *       / | \
 *      3  2  4
 *     / \
 *    5   6
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 */
public class _0429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                root = nodes.remove();
                list.add(root.val);
                if (root.children != null) {
                    nodes.addAll(root.children);
                }
            }
            result.add(list);
        }
        return result;
    }
}
