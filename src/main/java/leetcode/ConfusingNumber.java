package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 * 把原数字旋转180°以后得到新的数字。
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 * 2, 3, 4, 5, 7 旋转 180° 后,得到的不是数字。
 * 易混淆数字 (confusing number) 就是一个数字旋转180°以后，得到和原来不同的数字，且新数字的每一位都是有效的。
 *
 * 输入：6
 * 输出：true
 * 解释：
 * 把 6 旋转 180° 以后得到 9，9 是有效数字且 9!=6
 *
 * 输入：89
 * 输出：true
 * 解释:
 * 把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89
 *
 * 输入：11
 * 输出：false
 * 解释：
 * 把 11 旋转 180° 以后得到 11，11 是有效数字但是值保持不变，所以 11 不是易混淆数字
 *
 * 输入：25
 * 输出：false
 * 解释：
 * 把 25 旋转 180° 以后得到的不是数字
 *
 * @author 孙继峰
 * @date 2019/04/18
 */
public class ConfusingNumber {
    private Map<Integer, Integer> map = new HashMap<>(8);
    {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    public boolean confusingNumber(int N) {
        int ori = N;
        int rotate = 0;
        for (; N > 0; N /= 10) {
            int temp = N % 10;
            if (!map.containsKey(temp)) {
                return false;
            }
            rotate = rotate * 10 + map.get(temp);
        }
        return rotate != ori;
    }
}
