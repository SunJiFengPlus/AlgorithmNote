package leetcode;

/**
 * https://leetcode-cn.com/contest/weekly-contest-181/problems/four-divisors/
 *
 * @author 孙继峰
 * @since 2020/3/22
 */
public class FourDivisors {
    public static int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int divisorsNum = 0, divisorsSum = 0;
            for (int i = 1; i <= Math.sqrt(num) ; i++) {
                if (num % i == 0) {
                    if (num / i == i) {
                        divisorsNum++;
                        divisorsSum += i;
                    }
                    divisorsNum += 2;
                    divisorsSum += i + num / i;
                }
                if (divisorsNum > 4) {
                    break;
                }
            }
            if (divisorsNum == 4) {
                res += divisorsSum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        sumFourDivisors(new int[]{21, 4, 7});
    }
}
