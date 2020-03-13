package com.ulyssesss.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class _0128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> disjointSets = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            disjointSets.put(num, num);
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                int root1 = find(disjointSets, num);
                int root2 = find(disjointSets, num - 1);
                if (root1 != root2) {
                    disjointSets.put(num, root2);
                }
            }
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        for (int num : set) {
            int root = find(disjointSets, num);
            int newCount = countMap.getOrDefault(root, 0) + 1;
            if (newCount > result) {
                result = newCount;
            }
            countMap.put(root, newCount);
        }
        return result;
    }

    private int find(Map<Integer, Integer> set, int num) {
        if (set.get(num) == num) {
            return num;
        }
        int root = find(set, set.get(num));
        set.put(num, root);
        return root;
    }

    public int _longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                current += 1;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        return Math.max(longest, current);
    }

}
