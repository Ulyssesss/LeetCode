package com.ulyssesss.leetcode.solution;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 695. 岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 */
public class _0695 {

    /**
     * 并查集
     */
    public int maxAreaOfIsland(int[][] grid) {
        Map<String, Pair<Integer, Integer>> pairs = new HashMap<>();
        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> disjointSets = initDisjointSets(grid, pairs);
        unionAreas(disjointSets, grid, pairs);
        return getMax(disjointSets, grid, pairs);
    }

    private Map<Pair<Integer, Integer>, Pair<Integer, Integer>> initDisjointSets(int[][] grid
            , Map<String, Pair<Integer, Integer>> pairs) {
        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> disjointSets = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Pair<Integer, Integer> pair = getPair(pairs, i, j);
                disjointSets.put(pair, pair);
            }
        }
        return disjointSets;
    }

    private void unionAreas(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> disjointSets
            , int[][] grid, Map<String, Pair<Integer, Integer>> pairs) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                Pair<Integer, Integer> root = find(disjointSets, getPair(pairs, i, j));
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    Pair<Integer, Integer> root1 = find(disjointSets, getPair(pairs, i + 1, j));
                    if (!root.equals(root1)) {
                        disjointSets.put(root1, root);
                    }
                }

                if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                    Pair<Integer, Integer> root2 = find(disjointSets, getPair(pairs, i, j + 1));
                    if (!root.equals(root2)) {
                        disjointSets.put(root2, root);
                    }
                }
            }
        }
    }

    private Pair<Integer, Integer> getPair(Map<String, Pair<Integer, Integer>> pairs, int i, int j) {
        String key = i + "," + j;
        Pair<Integer, Integer> pair = pairs.get(key);
        if (pair == null) {
            pair = new Pair<>(i, j);
            pairs.put(key, pair);
        }
        return pair;
    }

    private Pair<Integer, Integer> find(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> disjointSets
            , Pair<Integer, Integer> pair) {
        Pair<Integer, Integer> root = disjointSets.get(pair);
        if (root.equals(pair)) {
            return root;
        }
        root = find(disjointSets, root);
        disjointSets.put(pair, root);
        return root;
    }

    private int getMax(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> disjointSets
            , int[][] grid, Map<String, Pair<Integer, Integer>> pairs) {
        int maxCount = 0;
        Map<Pair<Integer, Integer>, Integer> countMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Pair<Integer, Integer> root = find(disjointSets, getPair(pairs, i, j));
                    int newCount = countMap.getOrDefault(root, 0) + 1;
                    if (newCount > maxCount) {
                        maxCount = newCount;
                    }
                    countMap.put(root, newCount);
                }
            }
        }
        return maxCount;
    }

    /**
     * DFS
     */
    public int _maxAreaOfIsland(int[][] grid) {
        int[][] cloneGrid = grid.clone();
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result = Math.max(result, dfs(cloneGrid, i, j));
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        int num = 1;
        grid[i][j] = 0;
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i, j - 1);
        num += dfs(grid, i, j + 1);
        return num;
    }
}
