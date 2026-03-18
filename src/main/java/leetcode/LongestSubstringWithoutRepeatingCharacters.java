package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// leetcode 3
public class LongestSubstringWithoutRepeatingCharacters {
    
    /**
     * 双指针思路:
     * - 左指针指向字符串开始的index
     * - 右指针指向字符串结束的index
     * - 左指针右指针之间的子字符串为最长无重复子串
     * <p> 
     * 右指针移动的逻辑: 随迭代次数不断自增, 直到到达字符串末尾
     * 左指针移动的逻辑: 右指针指向的字符存在于左右指针间的子字符串中时, 移动到右指针字符最后一次出现的index+1位置 
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                left = Math.max(left, map.get(rightChar) + 1);
            }
            
            map.put(rightChar, right);
            max = Math.max(max, right-left+1);
        }
        
        return max;
    }

    /**
     * 暴力解法
     * 拆解出全部的子字符串: abcabcbb 拆为 a, ab, abc, abca, abcab, abcabc....
     *                                 b, bc, bca, bcab, bcabc, bcabcb....
     *                                 c, ca, cab, cabc, cabcb, cabcbb....
     * 把每一个字符都存入集合, 与子字符串后的第一个进行判断
     * 如果子字符串后第一个字符存在于集合中, 代表遇到的重复的字符, 能确定本轮迭代中最长无重复子串的长度了 
     * 如果子字符串后第一个字符不存在于集合中, 代表还没遇到重复的字符, 还可以再往后找
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        for (int start = 0; start < s.length(); start++) {
            Set<Character> knownChar = new HashSet<>();
            knownChar.add(s.charAt(start));
            int curMaxLength = 0;
            for (int end = start+1; end < s.length(); end++) {
                char endChar = s.charAt(end);
                if (knownChar.contains(endChar)) {
                    curMaxLength = Math.max(curMaxLength, end-start);
                    break;
                } else {
                    knownChar.add(endChar);
                    curMaxLength++;
                }
            }
            maxLength = Math.max(curMaxLength, maxLength);
        }
        return maxLength;
    }
}
