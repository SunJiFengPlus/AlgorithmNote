package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Unresolve
 * https://leetcode-cn.com/contest/biweekly-contest-22/problems/cinema-seat-allocation/
 * <p>
 * 每排最多 2 个四人组
 * 每排可分配四人组的位置: 2345, 4567, 6789
 *
 * @author 孙继峰
 * @since 2020/3/21
 */
public class CinemaSeatAllocation {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int canSeat = 2;
            Set<Integer> one = new HashSet<>(Arrays.asList(2,3,4,5));
            Set<Integer> two = new HashSet<>(Arrays.asList(4,5,6,7));
            Set<Integer> three = new HashSet<>(Arrays.asList(6,7,8,9));
            boolean oneFlag = true, twoFlag = true, threeFlag = true;
            for (int[] reservedSeat : reservedSeats) {
                int x = reservedSeat[0], y = reservedSeat[1];
                if (i == x) {
                    if (one.remove(y) && oneFlag) {
                        oneFlag = false;
                        canSeat--;
                    }
                    if (two.remove(y) && twoFlag) {
                        twoFlag = false;
                        canSeat--;
                    }
                    if (three.remove(y) && threeFlag) {
                        threeFlag = false;
                        canSeat--;
                    }
                }
            }
            res += (canSeat < 0 ? 0 : canSeat);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfFamilies(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}));
    }
}
