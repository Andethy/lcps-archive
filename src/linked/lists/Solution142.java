package linked.lists;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii">Linked List Cycle II</a>
 * Note: this is done with recursion, and is hence a pretty bad solution runtime wise.
 */
public class Solution142 {
    private class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
            }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        cycleHelper(head, head.next.next, dummyNode);
        return dummyNode.next;
    }

    public boolean cycleHelper(ListNode curr, ListNode ahead, ListNode start) {
        if (curr == null || ahead == null || ahead.next == null) {
            return false;
        } else if (curr == ahead) {
            start.next = curr;
            return true;
        } else if (cycleHelper(curr.next, ahead.next.next, start)) {
            return inCycle(curr, curr.next.next, start);
        } else {
            return false;
        }
    }

    public boolean inCycle(ListNode curr, ListNode ahead, ListNode start) {
        if (start.val == 1) {
            return false;
        }
        while (curr != ahead) {
            if (curr.next == ahead) {
                start.val = 1;
                start.next = curr.next;
                return true;
            }
            ahead = ahead.next;
        }
        System.gc();
        return true;
    }
}
