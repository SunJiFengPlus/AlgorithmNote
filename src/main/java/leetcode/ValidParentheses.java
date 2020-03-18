package leetcode;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author 孙继峰
 * @date 2019/03/13
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character: s.toCharArray()) {
            if (stack.empty()) {
                stack.push(character);
            } else if (match(character, stack.peek())) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        return stack.empty();
    }

    private boolean match(Character c1, Character c2) {
        switch (c1) {
            case '(':
                return c2.equals(')');
            case '[':
                return c2.equals(']');
            case '{':
                return c2.equals('}');
            case ')':
                return c2.equals('(');
            case ']':
                return c2.equals('[');
            case '}':
                return c2.equals('{');
            default:
                return false;
        }
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = ImmutableMap.of(')', '(', ']', '[', '}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && !map.get(c).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        Map<Character, Character> map = ImmutableMap.of(')', '(', ']', '[', '}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && !stack.isEmpty() && !stack.pop().equals(map.get(c))) {
                return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
