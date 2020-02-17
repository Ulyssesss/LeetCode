package com.ulyssesss.leetcode.contest._0176;

/**
 * 5340. 统计有序矩阵中的负数
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 *
 * 请你统计并返回 grid 中 负数 的数目。
 *
 * 示例 1：
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 *
 *
 * 示例 2：
 *
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 *
 *
 * 示例 3：
 *
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 *
 *
 * 示例 4：
 *
 * 输入：grid = [[-1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 */
public class _1_5340 {

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] i : grid) {
            for (int j : i) {
                if (j < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int _countNegatives(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] >= 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    if (j == 0) {
                        count += ((m - i) * n);
                        return count;
                    } else {
                        count += (n - j);
                        break;
                    }
                }
            }
        }
        return count;
    }
}
