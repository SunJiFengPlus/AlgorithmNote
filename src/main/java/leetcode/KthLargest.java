package leetcode;

import java.util.PriorityQueue;

/**
 * @author 孙继峰
 * @since 2020/3/19
 */
public class KthLargest {

    PriorityQueue<Integer> queue;
    int capacity;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k, Integer::compareTo);
        capacity = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() == capacity && val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        } else if (queue.size() != capacity) {
            queue.offer(val);
        }
        return queue.peek();
    }
}