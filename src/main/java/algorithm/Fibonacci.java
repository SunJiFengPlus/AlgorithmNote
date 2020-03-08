package algorithm;

/**
 * @author 孙继峰
 * @date 2019/12/26
 */
public class Fibonacci {
    public static void main(String[] args) {
        // 可行
        System.out.println(fibonacci(30));
        // 不可行
        System.out.println(fibonacci(50));
        System.out.println(fibonacci(100));
        System.out.println(fibonacci(1000));
    }

    /**
     * 1 1 2 3 5 8
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
