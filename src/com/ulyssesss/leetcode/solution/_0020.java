package com.ulyssesss.leetcode.solution;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class _0020 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char previous = stack.pop();
                if ((previous == '(' && current != ')')
                        || (previous == '[' && current != ']')
                        || (previous == '{' && current != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean _isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> mappings = new HashMap<>(5);
        mappings.put('}', '{');
        mappings.put(']', '[');
        mappings.put(')', '(');
        Stack<Character> stack = new Stack<>();
        char current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (mappings.containsKey(current)) {
                if (stack.isEmpty() || stack.pop() != mappings.get(current)) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }
}
