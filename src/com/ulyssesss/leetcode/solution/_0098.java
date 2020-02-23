package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *
 */
public class _0098 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode temp;
        if (root.left != null) {
            temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            if (temp.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            if (temp.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean _isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer[] pre = new Integer[]{null};
        return inorderTraversal(root, pre);
    }

    private boolean inorderTraversal(TreeNode root, Integer[] pre) {
        if (root == null) {
            return true;
        }
        if (!inorderTraversal(root.left, pre)) {
            return false;
        }
        if (pre[0] != null && root.val <= pre[0]) {
            return false;
        }
        pre[0] = root.val;
        return inorderTraversal(root.right, pre);
    }
}
