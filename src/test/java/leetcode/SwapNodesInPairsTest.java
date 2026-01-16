package leetcode;


import leetcode.structure.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwapNodesInPairsTest {
    @Test
    public void test1() {
        ListNode listNode = new SwapNodesInPairs().swapPairs(new ListNode(new int[]{1, 2, 3, 4}));
        assertThat(listNode.toArray()).isEqualTo(new int[]{2,1,4,3});
    }
}