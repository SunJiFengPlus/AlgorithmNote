package examination.netease.autumn;

import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/03
 */
public class Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //a的个数
        int m = scan.nextInt();
        //z的个数
        int n = scan.nextInt();
        //目标第几个
        long target = scan.nextInt();
        long k = 0;
        StringBuilder result = new StringBuilder();
        //当a和z均存在时执行
        while (m > 0 && n > 0) {
            //假设a确定，出去a之后剩余a和z的排列组合个数
            k = pz(m - 1, n, target);
            //如果确定a之后，剩余的排列组合数大于目标，则说明a已确定
            if (k >= target) {
                result.append('a');
                //a的个数减1
                m--;
            } else {
                //如果确定a之后，剩余的排列组合数小于目标，则说明不是a
                result.append('z');
                //z的个数减1
                n--;
                //目标减掉排列组合数。因为如果a开头可以有k中情况，
                target -= k;
                //减掉k之后即为确定z开头之后，接下来找第target个即可
            }
        }
        //存在经过计算之后必为1
        if (target != 1) {
            System.out.println("-1");
            return;
        } else {
            //如果z的个数为0，则将a追加到最后即可
            while (m > 0) {
                result.append('a');
                m--;
            }
            //如果a的个数为0，则将z追加到最后即可
            while (n > 0) {
                result.append('z');
                n--;
            }
        }
        System.out.print(result.toString());
    }

    /**
     * 计算假设a确定之后，a之后的部分排列组合数
     */
    private static long pz(int m, int n, long target) {
        if (m == 0 || n == 0) {
            return 1;
        }
        long sum = m + n;
        long k = 1;
        // C(m+n) n=C(m+n) m  取最小即可
        n = Math.min(m, n);
        for (int i = 0; i < n; i++) {
            k *= sum - i;
            k /= (i + 1);
            //防止大数。如果k>target 则只进行list.add("a")和m--//a的个数减1。
            //没有target -= k;因此不影响
            if (k > target) {
                break;
            }
        }
        return k;
    }
}