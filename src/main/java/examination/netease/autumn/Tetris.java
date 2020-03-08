package examination.netease.autumn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/01
 */
public class Tetris {
    /**
     * 牛客的编程题真的是太不优雅了
     * 100%
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        scanner.nextInt();

        int[] array = new int[column];
        while (scanner.hasNext()) {
            array[scanner.nextInt() - 1] ++;
        }

        Arrays.sort(array);
        System.out.println(array[0]);
    }
}
