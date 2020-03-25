package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author 孙继峰
 * @since 2020/3/24
 */
public class SlidingWindowMaximum {
    /**
     * 数据结构: 双向队列
     * 时间复杂度: O(n)
     * 空间复杂度: O(k)
     * 实现细节: 新元素从队首入队, 从队尾出队一个元素, 从队尾把比队首小的元素移除,
     *          保证队首元素到队尾元素是递增的
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getFirst() < nums[i]) {
                deque.removeFirst();
            }
            if (!deque.isEmpty() && i >= k && deque.getLast() == nums[i - k]) {
                deque.removeLast();
            }
            deque.addFirst(nums[i]);
            res[i] = deque.getLast();
        }
        return Arrays.copyOfRange(res, k - 1, nums.length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
}
