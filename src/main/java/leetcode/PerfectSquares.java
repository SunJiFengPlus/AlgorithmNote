package leetcode;

public class PerfectSquares {

    /**
     * 最小问题: 
     * - "x" 最少需要多少个平方数组成? 
     * - "x-某一个平方数" 最少需要多少个平方数组成?
     * 最少平方数数组: i最少需要多少个平方数组成, i从1开始
     * dp = [1,2,3,1,2,3,4,2,1,2, 3, 3]
     *       1,2,3,4,5,6,7,8,9,10,11,12
     * dp[n] 则与 dp[1] 到 dp[n-1] 有关, 也即: dp[n] = f(dp[1], dp[2]....dp[n-1])
     * <p> 
     * 1,4,9,16,25,36,49
     * 具体f(n)的逻辑为: min(n/dp[n-1]+dp[n%dp[n-1]], n/dp[n-2]+dp[n%dp[n-2]], n/dp[n-3]+dp[n%dp[n-3]]....)
     * 但这个会超时
     */
    public int numSquares1(int n) {
        // 初始化部分dp数组
        int[] dp = new int[n+1];
        for (int i = 1; i*i <= n; i++) {
            dp[i*i] = 1;
        }
        
        // 优化: n刚好落在dp数字中,就不需要计算了,直接返回
        if (dp[n] != 0) {
            return dp[n];
        }
        
        // 填充dp数组
        for (int i = 2; i <= n; i++) {
            if (dp[i] != 0) {
                continue;
            }
            dp[i] = i;
            int min = i; 
            for (int j = n-1; j >= 1; j--) {
                int divideNum = i/j*dp[j];
                int modNum = dp[i%j];
                int num = divideNum + modNum;
                min = Math.min(min, num);
            }
            dp[i] = min;
        }
        
        return dp[n];
    }

    /**
     * 参考题解
     * f(i) = min(f[i], f[i-j*j]+1)
     */
    public int numSquares2(int n) {
        // 初始化部分dp数组
        int[] dp = new int[n+1];
        for (int i = 1; i*i <= n; i++) {
            dp[i*i] = 1;
        }

        // 优化: n刚好落在dp数字中,就不需要计算了,直接返回
        if (dp[n] != 0) {
            return dp[n];
        }

        // 填充dp数组
        for (int i = 2; i <= n; i++) {
            if (dp[i] != 0) {
                continue;
            }
            dp[i] = i;
            for (int j = 1; j <= i-j*j; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }
}
