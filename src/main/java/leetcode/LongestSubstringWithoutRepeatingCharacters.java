package leetcode;

import java.util.HashMap;
import java.util.Map;

// leetcode 3
public class LongestSubstringWithoutRepeatingCharacters {
    
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
}
