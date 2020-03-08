package examination.ifly.autumn;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 话说不直接输出??? 那你答题模板和之前的都不一样啊 搞得我好晕啊
 *
 * @author 孙继峰
 * @date 2019/08/16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // 有无数字
        boolean hasNumber = false;
        List<Character> res = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                res.add(c);
                hasNumber = true;
            }
        }

        // 虽然卑鄙点, 但是手写确实费事, 东西都在我脑子里呢 hhhhh
        Collections.sort(res);

        if (hasNumber) {
            res.forEach(System.out::print);
        } else {
            System.out.println(-1);
        }

    }
}

class Main2 {

    /**
     * 返回 target 在数组中的索引
     *
     * @param array  数组
     * @param target 查找目标
     */
    static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int low, int high) {
        int mid = (low + high) >>> 1;
        int midVal = array[mid];

        if (midVal > target) {
            binarySearch(array, target, low, mid - 1);
        }
        else if (midVal < target) {
            binarySearch(array, target, mid + 1, high);
        }
        else {
            return mid;
        }
        return -1;
    }
}