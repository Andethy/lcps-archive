package nc.linked.list;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 */
class Solution143 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = getMidNode(head, head);
        ListNode list2 = reverseList(mid, null);
        ListNode curr = head;
        ListNode temp = list2;

        while (list2 != null) {
            list2 = list2.next;
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
            temp = list2;
        }
        if (curr.next.next.next != null) {
            curr.next.next.next = null;
        } else {
            curr.next.next = null;
        }

    }

    private ListNode getMidNode(ListNode slow, ListNode fast) {
        if (fast == null) {
            return slow;
        } else if (fast.next == null) {
            return slow.next;
        } else {
            return getMidNode(slow.next, fast.next.next);
        }
    }

    private ListNode reverseList(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        } else {
            ListNode temp = curr.next;
            curr.next = prev;
            return reverseList(temp, curr);
        }
    }
}
