package leetcode;

import java.util.*;
import java.util.stream.Collectors;

import datastruture.Array;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author 孙继峰
 * @since 2020/3/26
 */
public class ThreeSum {
    /**
     * 双向指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start, end;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (end > start) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
