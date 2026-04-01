package leetcode;

import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的  的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAllAnagramsInAString {
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> target = new HashMap<>();
        for (char c : p.toCharArray()) {
            addToWindow(c, target);
        }

        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            // 构建滑动窗口
            if (end < p.length()) {
                addToWindow(s.charAt(end), window);
            } else {
                addToWindow(s.charAt(end), window);
                removeFromWindow(s.charAt(start), window);
                start++;
            }
            
            // 是异位词
            if (Objects.equals(window, target)) {
                res.add(start);
            }
        }
        
        return res;
    }

    public void addToWindow(char c, Map<Character, Integer> target) {
        if (target.containsKey(c)) {
            target.put(c, target.get(c)+1);
        } else {
            target.put(c, 1);
        }
    }

    public void removeFromWindow(char c, Map<Character, Integer> target) {
        if (target.containsKey(c)) {
            Integer num = target.get(c);
            if (Objects.equals(num, 1)) {
                target.remove(c);
            } else {
                target.put(c, num-1);
            }
        }
    }
}
