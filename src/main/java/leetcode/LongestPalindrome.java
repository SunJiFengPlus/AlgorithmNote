package leetcode;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @author 孙继峰
 * @since 2020/3/19
 */
public class LongestPalindrome {
    /*
     *  A-65 Z-90 a-97 z-122
     */
    public int longestPalindrome(String s) {
        int[] array = new int[26 * 2];
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                array[c - 65]++;
            } else {
                array[c - 'a' + 25]++;
            }
        }

        int ans = 0;
        for (int v: array) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}
