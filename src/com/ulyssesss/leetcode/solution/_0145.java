package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class _0145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalWithList(list, root);
        return list;
    }

    private void postorderTraversalWithList(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalWithList(list, root.left);
        postorderTraversalWithList(list, root.right);
        list.add(root.val);
    }

}
