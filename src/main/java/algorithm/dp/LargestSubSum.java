package algorithm.dp;

import java.util.Scanner;

/**
 * 输入一个整形数组（可能有正数和负数），求数组中连续子数组（最少有一个元素）的最大和。要求时间复杂度为O(n)。
 * <p>
 * 输入描述:
 * 【重要】第一行为数组的长度N（N>=1）
 * 接下来N行，每行一个数，代表数组的N个元素
 * <p>
 * 输出描述:
 * 最大和的结果
 * <p>
 * 示例1
 * 输入
 * 8
 * 1
 * -2
 * 3
 * 10
 * -4
 * 7
 * 2
 * -5
 * <p>
 * 输出
 * 18
 * <p>
 * 说明
 * 最大子数组为 3, 10, -4, 7, 2
 *
 * @author 孙继峰
 * @date 2019/08/19
 */
public class LargestSubSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(largestSubSum(num, numbers));
    }

    /**
     * f(i): 从 index 为 i 开始最大子数组的和
     * f(i) = max(f(i+1), numbers[i])
     *
     * numbers = {1, -2, 3, 10, -4, 7, 2, -5}
     * f(0) = max(f(1), 1)  = max(16 + 1, 16) = 17
     * f(1) = max(f(2), -2) = max(18 - 2, -2) = 16
     * f(2) = max(f(3), 3)  = max(15 + 3, 3) = 18
     * f(3) = max(f(4), 10) = max(5 + 10, 10) = 15
     * f(4) = max(f(5), -4) = max(9 - 4, -4) = 5
     * f(5) = max(f(6), 7)  = max(7 + 2, 7) = 9
     * f(6) = max(f(7), 2)  = max(-5 + 2, 2) = 2
     * f(7) = max(f(8), -5) = max(-5 + null, -5) = -5
     */
    private static int largestSubSum(int num, int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int i = num - 1; i >= 0; i--) {
            numbers[i] = i == num - 1 ? numbers[i] : Math.max(numbers[i], numbers[i] + numbers[i + 1]);
            max = Math.max(numbers[i], max);
        }
        return max;
    }
}
