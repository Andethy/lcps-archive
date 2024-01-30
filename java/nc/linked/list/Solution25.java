package nc.linked.list;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group">Reverse Nodes in k-Group</a>
 */
class Solution25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode combinedList = new ListNode();
        ListNode curr = combinedList;
        while (dummy.next != null) {
            curr.next = reverseSubList(head, null, k, 0, dummy);
            if (dummy.val < k) {
                curr.next = reverseSubList(curr.next, null, dummy.val, 0, dummy);
            }
            curr = head;
            head = dummy.next;

        }
        return combinedList.next;

    }

    public ListNode reverseSubList(ListNode curr, ListNode prev, int k, int count, ListNode dummy) {
        if (k == count || curr == null) {
            dummy.val = count;
            dummy.next = curr;
            // System.out.println(curr == null ? "null" : curr.val);
            // System.out.println(prev == null ? "null" : prev.val);
            return prev;
        } else {
            ListNode temp = curr.next;
            curr.next = prev;
            return reverseSubList(temp, curr, k, count + 1, dummy);
        }
    }
}
