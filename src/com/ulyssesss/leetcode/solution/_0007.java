package com.ulyssesss.leetcode.solution;

/**
 *
 * 7. 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2 31,  2 31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class _0007 {

    public int reverse(int x) {
        int maxNeedCheck = Integer.MAX_VALUE / 10;
        int minNeedCheck = Integer.MIN_VALUE / 10;
        int maxRemainder = Integer.MAX_VALUE % 10;
        int minRemainder = Integer.MIN_VALUE % 10;
        int result = 0;
        while (x != 0) {
            int remainder = x % 10;
            if (result > maxNeedCheck || (result == maxNeedCheck && remainder > maxRemainder)) {
                return 0;
            }
            if (result < minNeedCheck || (result == minNeedCheck && remainder < minRemainder)) {
                return 0;
            }
            result = result * 10 + remainder;
            x /= 10;
        }
        return result;
    }

}
