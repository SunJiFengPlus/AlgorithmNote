package examination.atman.autumn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 孙继峰
 * @date 2019/08/29
 */
public class Main {
    private static final int IPV4_SEGMENT = 4;
    private static final int IPV6_SEGMENT = 6;
    private static final int ASCII_NUM = 1 << 8;

    @Test
    public void testIsIPV4() {
        // 正确验证
        Assert.assertTrue(isIPV4("192.168.0.1"));
        // 强制错误验证
        Assert.assertFalse(isIPV4(null));
        Assert.assertFalse(isIPV4("256.-1.5.6"));
        Assert.assertFalse(isIPV4("0.0.0."));
    }

    /**
     * 思想:分段判断
     */
    private static boolean isIPV4(String ip) {
        String[] segments;
        if (ip == null || (segments = ip.split("\\.")).length != IPV4_SEGMENT) {
            return false;
        }
        for (int i = 0; i < IPV4_SEGMENT; i++) {
            int currentValue = Integer.valueOf(segments[i]);
            if (currentValue < 0 || currentValue > 255) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIPV6(String ip) {
        return false;
    }

    @Test
    public void testFindSingleChar() {
        // 正确输入
        Assert.assertEquals('c', findSingleChar("abcd13faeb"));

        // 强制错误输入
        try {
            findSingleChar(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("输入为空", e.getMessage());
        }
        try {
            findSingleChar("");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("输入为空", e.getMessage());
        }
        try {
            findSingleChar("aabbcc");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("不存在只出现一次的字符", e.getMessage());
        }

    }

    /**
     * 假设输入的字符都在 ASCII 码表中, ASCII 码范围 0 - 255
     * 位图法, byte[256] 保存每个字符出现的次数
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * 相对 HashMap 的实现, 位图法适合用在更大数据量的场景下, 查找快于 HashMap
     */
    private char findSingleChar(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("输入为空");
        }
        byte[] ascii = new byte[ASCII_NUM];
        for (int i = 0, length = input.length(); i < length; i++) {
            ascii[input.charAt(i)]++;
        }
        for (int i = 0, length = input.length(); i < length; i++) {
            char currentChar = input.charAt(i);
            if (ascii[currentChar] == 1) {
                return currentChar;
            }
        }
        throw new IllegalArgumentException("不存在只出现一次的字符");
    }
}
