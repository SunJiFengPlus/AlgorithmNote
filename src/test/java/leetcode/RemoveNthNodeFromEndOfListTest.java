package leetcode;


import leetcode.structure.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveNthNodeFromEndOfListTest {
    @Test
    public void test1() {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2);
        assertThat(res.toArray()).isEqualTo(new int[]{1,2,3,5});
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(new int[]{1});
        ListNode res = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);
        assertThat(res).isNull();
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(new int[]{1, 2});
        ListNode res = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);
        assertThat(res.toArray()).isEqualTo(new int[]{1});
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(new int[]{1, 2});
        ListNode res = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2);
        assertThat(res.toArray()).isEqualTo(new int[]{2});
    }
}