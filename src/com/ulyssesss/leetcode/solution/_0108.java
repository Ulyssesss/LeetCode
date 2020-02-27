package com.ulyssesss.leetcode.solution;

import com.ulyssesss.leetcode.common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class _0108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return generateNode(nums, 0, nums.length - 1);
    }

    private TreeNode generateNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int midIndex = (start + end) / 2;
            if ((start + end) % 2 != 0) {
                midIndex++;
            }
            TreeNode node = new TreeNode(nums[midIndex]);
            node.left = generateNode(nums, start, midIndex - 1);
            node.right = generateNode(nums, midIndex + 1, end);
            return node;
        }
    }
}
