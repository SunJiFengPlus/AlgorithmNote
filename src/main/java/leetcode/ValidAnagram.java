package leetcode;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author 孙继峰
 * @since 2020/3/25
 */
public class ValidAnagram {
    /**
     * 使用 Ascii 码进行哈希
     */
    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            array[c - 'a']--;
        }
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
