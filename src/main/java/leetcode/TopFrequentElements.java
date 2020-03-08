package leetcode;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log4j n) , n 是数组的大小。
 *
 * @author 孙继峰
 * @date 2019/04/09
 */
public class TopFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 存储数字与对应的频次
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 使用优先队列存储频次最大的前 k 个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
