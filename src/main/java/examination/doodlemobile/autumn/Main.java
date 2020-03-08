package examination.doodlemobile.autumn;

import org.junit.Assert;

/**

 *
 * @author 孙继峰
 * @date 2019/08/26
 */
public class Main {
    public static void main(String[] args) {
        Assert.assertFalse(splitAndMerge("aab", "bbc"));
        Assert.assertTrue(splitAndMerge("aab", "aaabc"));
        Assert.assertTrue(splitAndMerge("", "aaabc"));
        Assert.assertFalse(splitAndMerge("aab", ""));
        Assert.assertTrue(splitAndMerge("", ""));
    }

    /**
     * 给定两个字符串A和B ，判断A是否能由B中的含有的字符组成，B中的每个字符只能使用一次
     * ("a", "b") -> false
     * ("aa", "ab") -> false
     * ("aa", "aab") -> true
     *
     * 假设输入的字符都在 ASCII 码表中, ASCII 码范围 0 - 255
     * 位图法, byte[256] 保存每个字符出现的次数
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static boolean splitAndMerge(String a, String b) {
        byte[] ascii = new byte[256];
        for (int i = 0, length = b.length(); i < length; i++) {
            ascii[b.charAt(i)]++;
        }
        for (int i = 0, length = a.length(); i < length; i++) {
            int currentIndex = a.charAt(i);
            if (ascii[currentIndex] == 0) {
                return false;
            }
            ascii[currentIndex]--;
        }
        return true;
    }

    /**
     * 第二题: 不会, 抱歉, 能力有限
     */
    private static String caculate(String input) {
        return null;
    }
}