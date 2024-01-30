package nc.linked.list;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">Remove Nth Node From End of List</a>
 */
class Solution19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(0, head);
        ListNode slow = fast;
        ListNode result = slow;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return result.next;
    }
}

