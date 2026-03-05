package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

// leetcode 189
public class RotateArray {

    // 维护一个链表, 循环从尾部取出, 然后放到头部, 循环k次
    public void rotate1(int[] nums, int k) {
        LinkedList<Integer> list = Arrays.stream(nums).boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < k; i++) {
            list.addFirst(list.removeLast());
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }

    // 数组拷贝
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        
        k %= nums.length;
        int offset = (nums.length - k) % nums.length;
        System.arraycopy(temp, offset, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, offset);
    }
}
