package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 * 提示：
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 */
public class LongestConsecutive {
    
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return nums.length;
        }
        
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int preLongest = 1;
        int curLongest = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (isConsecutive(nums[i], nums[i+1])) {
                curLongest++;
                if (i == nums.length - 2) {
                    preLongest = Math.max(preLongest, curLongest);
                }
            } else{
                preLongest = Math.max(preLongest, curLongest);
                curLongest = 1;
            }
        }
        
        return preLongest;
    }
    
    public boolean isConsecutive(int a, int b) {
        return Math.abs(a - b) == 1;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return nums.length;
        }

        // 这个性能会低很多, 虽然写起来很酷
        // Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int preLongest = 1;
        int curLongest = 1;
        for (Integer i : set) {
            if (set.contains(i -1)) {
                continue;
            }
            
            for (int j = 1; set.contains(i + j); j++) {
                curLongest++;
            }
            preLongest = Math.max(curLongest, preLongest);
            curLongest = 1;
        }
        
        return preLongest;
    }
}
