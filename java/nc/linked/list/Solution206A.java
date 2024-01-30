package nc.linked.list;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list">Reverse Linked List</a>
 */
class Solution206A {

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();
        reverseH(head, newHead);
        return newHead.next;

    }

    private ListNode reverseH(ListNode curr, ListNode head) {
        if (curr == null) {
            return null;
        } else if (curr.next == null) {
            head.next = curr;
            return curr;
        } else {
            ListNode last = reverseH(curr.next, head);
            last.next = new ListNode(curr.val);
            return last.next;
        }
    }
}
