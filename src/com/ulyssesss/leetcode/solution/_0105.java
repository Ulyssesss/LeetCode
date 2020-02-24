package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class _0105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(new int[]{0}, preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorderIndex, int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex[0]]);
        preorderIndex[0]++;
        if (start < end) {
            int index = findIndex(inorder, root.val, start, end);
            root.left = buildTreeHelper(preorderIndex, preorder, inorder, start, index - 1);
            root.right = buildTreeHelper(preorderIndex, preorder, inorder, index + 1, end);
        }
        return root;
    }

    private int findIndex(int[] array, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
