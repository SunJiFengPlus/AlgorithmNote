package leetcode;


/**
 * @author 孙继峰
 * @date 2019/07/13
 */
public class StringMatch {

    /**
     * jdk 默认采用的是 BF 算法, 也就是最暴力最易理解的挨个匹配
     * java 常用场景中的 String 并不长, 常用场景中 KMP 不会带来太多的性能提升,
     * KMP 反而会增加系统时间与空间开销
     */
    int indexOf(byte[] value, int valueCount, byte[] str, int strCount, int fromIndex) {
        byte first = str[0];
        int max = (valueCount - strCount);
        for (int i = fromIndex; i <= max; i++) {
            // Look for first character.
            if (value[i] != first) {
                while (++i <= max && value[i] != first) {
                }
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + strCount - 1;
                for (int k = 1; j < end && value[j] == str[k]; j++, k++) {
                }
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * KMP 开始匹配
     *
     *           ↓
     * √ √ √ √ √ ×
     * A B C A B C D H I J K
     *           ↓
     * √ √ √ √ √ ×
     * A B C A B B C C
     *
     * 模式串不匹配位置的左边有两个相同的子串 AB(公共前后缀), 并且两个 AB 在前面的匹配过程中成功
     * 主串不回溯, 模式串回溯到第一个公共前后缀的下一个位置
     *
     *           ↓
     * A B C A B C D H I J K
     *           ↓
     *       A B C A B B C C
     *
     * 继续匹配
     *
     *             ↓
     *           √ ×
     * A B C A B C D H I J K
     *             ↓
     *           √ ×
     *       A B C A B B C C
     *
     * 不匹配位置左边没有公共子串, 模式串回溯到第一位
     *
     *             ↓
     * A B C A B C D H I J K
     *             ↓
     *             A B C A B B C C
     *
     * 模式串超出主串长度, 判定不匹配
     */

    public int kmp(String main, String pattern) {
        char[] t = main.toCharArray();
        char[] p = pattern.toCharArray();
        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        // 模式串 next 数组
        int[] next = getNext(pattern);

        while (i < t.length && j < p.length) {
            // 当j为-1时，要移动的是i，当然j也要归0
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                // j回到指定位置
                j = next[j];
            }
        }

        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0, k = -1;

        while (j < p.length - 1) {
            // 短路特性保证数组不会越界
            if (k == -1 || p[j] == p[k]) {
                // 当两个字符相等时要跳过
                if (p[++j] == p[++k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}