package com.ulyssesss.leetcode.solution;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class _0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> found = new HashSet<>();
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = numIndexMap.get(nums[i]);
            if (indexList == null) {
                indexList = new ArrayList<>();
                indexList.add(i);
                numIndexMap.put(nums[i], indexList);
            } else {
                indexList.add(i);
            }
        }
        Set<Integer> finishFirst = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (finishFirst.contains(nums[i])) {
                continue;
            }
            Set<Integer> finishSecond = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (finishSecond.contains(nums[j])) {
                    continue;
                }
                int toFind = 0 - nums[i] - nums[j];
                List<Integer> targetIndexList = numIndexMap.get(toFind);
                if (targetIndexList == null) {
                    continue;
                }
                List<Integer> item = Arrays.asList(nums[i], nums[j], toFind);
                item.sort(Integer::compareTo);
                String key = item.stream().map(String::valueOf).collect(Collectors.joining(","));
                if (found.contains(key)) {
                    continue;
                }
                for (int index : targetIndexList) {
                    if (index != i && index != j) {
                        found.add(key);
                        result.add(item);
                        break;
                    }
                }
                finishSecond.add(nums[j]);
            }
            finishFirst.add(nums[i]);
        }
        return result;
    }

    public List<List<Integer>> _threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int left, right, sum;
        int maxIndex = nums.length - 1;
        for (int i = 0; i < maxIndex; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = maxIndex;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}
