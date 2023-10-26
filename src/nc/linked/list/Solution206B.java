package nc.linked.list;

public class Solution206B {
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
        return reverseH(head, null);

    }

    private ListNode reverseH(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        } else {
            ListNode temp = curr.next;
            curr.next = prev;
            return reverseH(temp, curr);
        }
    }
}
