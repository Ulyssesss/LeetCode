package com.ulyssesss.leetcode.solution;

import java.util.*;

/**
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 *
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 *
 * 提示：
 *
 * 1.输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 2.你可以假定输入的先决条件中没有重复的边。
 * 3. 1 <= numCourses <= 10^5
 *
 */
public class _0207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegreeArray = new int[numCourses];
        Queue<Integer> indegreeZeroQueue = new LinkedList<>();
        List<List<Integer>> outdegree = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            outdegree.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            indegreeArray[prerequisite[0]]++;
            outdegree.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegreeArray[i] == 0) {
                indegreeZeroQueue.add(i);
            }
        }

        while (!indegreeZeroQueue.isEmpty()) {
            numCourses--;
            for (Integer nextCourse: outdegree.get(indegreeZeroQueue.remove())) {
                if (--indegreeArray[nextCourse] == 0) {
                    indegreeZeroQueue.add(nextCourse);
                }
            }
        }
        return numCourses == 0;
    }

    public boolean _canFinish(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        List<List<Integer>> outdegree = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            outdegree.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            outdegree.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(outdegree, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> outdegree, int[] flag, int i) {
        if (flag[i] == 1) {
            return false;
        }
        if (flag[i] == -1) {
            return true;
        }
        flag[i] = 1;
        for (Integer next : outdegree.get(i)) {
            if (!dfs(outdegree, flag, next)) {
                return false;
            }
        }
        flag[i] = -1;
        return true;
    }

}
