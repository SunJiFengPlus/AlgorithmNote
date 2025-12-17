package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * 提示:
 *     1 <= nums.length <= 104
 *     -231 <= nums[i] <= 231 - 1
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++, j=i) {
            if (nums[i] != 0) {
                continue;
            }
            
            // 后指针向后找到一个非0的
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            
            if (j == nums.length) {
                break;
            }
            
            nums[i] = nums[j];
            nums[j] = 0;
        }
    }

    // 执行用时击败 8.56%, 消耗内存击败14.58%
    public void moveZeroes2(int[] nums) {
        int curIndex = 0;
        while (curIndex < nums.length) {
            if (nums[curIndex] != 0) {
                curIndex++;
                continue;
            }
            
            int zeroEndIndex = curIndex;
            while (zeroEndIndex < nums.length && nums[zeroEndIndex] == 0) {
                zeroEndIndex++;
            }
            
            moveBack(nums, curIndex, zeroEndIndex);
            
            curIndex++;
        }
    }

    protected void moveBack(int[] array, int start, int end) {
        if (start == end) {
            return;
        }

        for (int i = 0; (i < end - start) && (end+i < array.length) ; i++) {
            int temp = array[start+i];
            array[start+i] = array[end+i];
            array[end+i] = temp;
        }
    }

    // 执行用时击败 5.24%, 消耗内存击败17.69%
    public void moveZeroes1(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.addLast(num);
        }

        Iterator<Integer> iterator = list.iterator();
        int sumZero = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 0) {
                iterator.remove();
                sumZero++;
            }
        }

        for (int i = 0; i < sumZero; i++) {
            list.addLast(0);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }
}
