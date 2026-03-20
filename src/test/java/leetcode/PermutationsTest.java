package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {
    
    private final Permutations permutations = new Permutations();

    @Test
    public void test1() {
        // 示例 1: nums = [1,2,3]
        // 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        List<List<Integer>> result = permutations.permute(new int[]{1, 2, 3});
        
        // 验证结果数量应该是 6 (3! = 6)
        assertThat(result).hasSize(6);
        
        // 验证包含所有可能的排列
        assertThat(result).containsAll(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 3, 2),
            Arrays.asList(2, 1, 3),
            Arrays.asList(2, 3, 1),
            Arrays.asList(3, 1, 2),
            Arrays.asList(3, 2, 1)
        ));
    }

    @Test
    public void test2() {
        // 示例 2: nums = [0,1]
        // 输出：[[0,1],[1,0]]
        List<List<Integer>> result = permutations.permute(new int[]{0, 1});
        
        // 验证结果数量应该是 2 (2! = 2)
        assertThat(result).hasSize(2);
        
        // 验证包含所有可能的排列
        assertThat(result).containsAll(Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 0)
        ));
    }

    @Test
    public void test3() {
        // 示例 3: nums = [1]
        // 输出：[[1]]
        List<List<Integer>> result = permutations.permute(new int[]{1});
        
        // 验证结果数量应该是 1 (1! = 1)
        assertThat(result).hasSize(1);
        
        // 验证唯一的排列
        assertThat(result.get(0)).isEqualTo(Arrays.asList(1));
    }

    @Test
    public void testEmptyArray() {
        // 边界情况：空数组
        List<List<Integer>> result = permutations.permute(new int[]{});
        
        // 空数组应该返回空列表
        assertThat(result).isEmpty();
    }

    @Test
    public void testFourElements() {
        // 测试 4 个元素的情况：[1,2,3,4]
        List<List<Integer>> result = permutations.permute(new int[]{1, 2, 3, 4});
        
        // 验证结果数量应该是 24 (4! = 24)
        assertThat(result).hasSize(24);
        
        // 验证每个排列都包含所有 4 个元素
        for (List<Integer> permutation : result) {
            assertThat(permutation).hasSize(4);
            assertThat(permutation).containsExactlyInAnyOrder(1, 2, 3, 4);
        }
    }
}
