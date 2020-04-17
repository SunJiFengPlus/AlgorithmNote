package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author 孙继峰
 * @since 2020/4/17
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int canJump = 0;
        for (int i = 0; i < nums.length - 1; i++, canJump--) {
            canJump = Math.max(nums[i], canJump);
            if (canJump == 0) {
                return false;
            }
        }
        return canJump >= 0;
    }

    @Test
    public void test1() {
        Assertions.assertThat(canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
    }

    @Test
    public void test2() {
        Assertions.assertThat(canJump(new int[]{0,2,3})).isFalse();
    }
}
