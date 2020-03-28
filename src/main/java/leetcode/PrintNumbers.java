package leetcode;

import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author 孙继峰
 * @since 2020/3/30
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        return Stream
                .iterate(1, i -> i + 1)
                .limit((int)Math.pow(10, n) - 1)
                .mapToInt(value -> value)
                .toArray();
    }
}
