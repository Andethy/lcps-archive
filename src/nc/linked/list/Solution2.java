package nc.linked.list;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
class Solution2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode curr = result;
        int overflow = 0;

        while (l1 != null || l2 != null) {
            int left = l1 == null ? 0 : l1.val;
            int right = l2 == null ? 0 : l2.val;
            int sum = left + right + overflow;
            curr.next = new ListNode(sum % 10);
            overflow = sum < 10 ? 0 : 1;

            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (overflow == 1) {
            curr.next = new ListNode(1);
        }

        return result.next;
    }
}

