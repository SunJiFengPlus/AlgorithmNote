package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
 *
 * @author 孙继峰
 * @since 2020/3/22
 */
public class CreateTargetArrayInTheGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {
        createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1});
    }
}
