package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class _0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalWithList(list, root);
        return list;
    }

    private void inorderTraversalWithList(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalWithList(list, root.left);
        list.add(root.val);
        inorderTraversalWithList(list, root.right);
    }

    public List<Integer> _inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;

            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
