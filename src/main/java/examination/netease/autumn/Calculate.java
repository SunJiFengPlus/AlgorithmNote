package examination.netease.autumn;

import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/02
 */
public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(max(a,b,c));
    }

    /**
     * 100%, 我的提交
     */
    public static int max(int a, int b, int c) {
        if (a == 1) {
            return Math.max(a + ((b==1||c==1)? b+c :b*c), (a+b)*c);
        }
        return a*b*c;
    }


}