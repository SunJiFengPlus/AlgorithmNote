package examination.zhaoyin.spring;

import java.util.Scanner;

/**
 * @author 孙继峰
 * @since 2020/3/27
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int groupNum = in.nextInt();
        for (int i = 0; i < groupNum; i++) {
            int n = in.nextInt();
            int[] stocksNum = new int[n];
            for (int j = 0; j < n; j++) {
                stocksNum[j] = in.nextInt();
            }
        }
    }

    public static void answer(int n, int[] stocksNum) {
        int res = 0;
        for (int i : stocksNum) {
            res++;
        }
        if (res <= n) {
            System.out.println(-1);
        } else {
            System.out.println(res + 1);
        }
    }
}
