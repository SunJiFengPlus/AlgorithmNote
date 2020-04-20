package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author 孙继峰
 * @since 2020/4/20
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (flag > 0 ? flag-- : 0);
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }
}
