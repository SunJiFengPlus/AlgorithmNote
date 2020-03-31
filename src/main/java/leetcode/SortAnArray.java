package leetcode;

import java.util.Arrays;

/**
 * @see algorithm.sort.BubbleSort
 * @see algorithm.sort.BubbleSort2
 * @see algorithm.sort.HeapSort
 * @see algorithm.sort.InsertSort
 * @see algorithm.sort.MergeSort
 * @see algorithm.sort.QuickSort
 * @see algorithm.sort.SelectionSort
 * @see algorithm.sort.ShellSort
 * @author 孙继峰
 * @since 2020/3/31
 */
public class SortAnArray {
    /**
     * 懒惰写法, 但是题目肯定不是想让我这样完成的
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
