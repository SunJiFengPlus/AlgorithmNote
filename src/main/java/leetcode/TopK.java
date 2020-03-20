package leetcode;

import java.util.*;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 *
 *     0 <= k <= arr.length <= 10000
 *     0 <= arr[i] <= 10000
 *
 * @author 孙继峰
 * @since 2020/3/20
 */
public class TopK {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 1) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i : arr) {
            if (queue.size() == k && i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            } else if (queue.size() != k) {
                queue.offer(i);
            }
        }
        int[] res = new int[k];
        for (int i = 0, size = queue.size(); i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        System.out.println(Arrays.toString(topK.getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }
}
