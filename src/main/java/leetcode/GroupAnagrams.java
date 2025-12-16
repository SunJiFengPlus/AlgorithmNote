package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    /**
     * 给你一个字符串数组，请你将 组合在一起。可以按任意顺序返回结果列表。
     * 示例 1:
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 解释：
     *     在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     *     字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     *     字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 示例 2:
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        
        List<String> input = Arrays.stream(strs).collect(Collectors.toList());
        while (!input.isEmpty()) {
            Iterator<String> iterator = input.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                String sortedNext = sort(next);
                iterator.remove();
                if (res.containsKey(sortedNext)) {
                    res.get(sortedNext).add(next);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(next);
                    res.put(sortedNext, tmp);
                }
            }
        }
        
        return new ArrayList<>(res.values());
    }

    private String sort(String cur) {
        char[] charArray = cur.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
