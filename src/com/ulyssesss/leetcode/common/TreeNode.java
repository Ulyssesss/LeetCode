package com.ulyssesss.leetcode.common;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public static TreeNode createNodes(Integer[] array) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                nodes.put(i, new TreeNode(array[i]));
            }
        }
        for (int i = 0; i < array.length; i++) {
            TreeNode node = nodes.get(i);
            if (node != null) {
                node.left = nodes.get(i * 2 + 1);
                node.right = nodes.get(i * 2 + 2);
            }
        }
        return nodes.get(0);
    }

    public TreeNode(int x) {
        this.val = x;
    }
}
