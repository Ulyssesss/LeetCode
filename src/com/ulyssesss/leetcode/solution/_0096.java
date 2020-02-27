package com.ulyssesss.leetcode.solution;

/**
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class _0096 {

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        } else {
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += numTrees(i) * numTrees(n - i - 1);
            }
            return result;
        }
    }

    public int _numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        return result[n];
    }

    /**
     * 卡塔兰数 公式
     * https://baike.baidu.com/item/catalan/7605685?fr=aladdin
     */
    public int __numTrees(int n) {
        long result = 1;
        for (int i = 0; i < n; ++i) {
            result = result * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) result;
    }
}
