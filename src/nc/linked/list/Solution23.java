package nc.linked.list;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists">Merge k Sorted Lists</a>
 */
class Solution23 {

    @SuppressWarnings("InnerClassMayBeStatic")
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 0) {
            return null;
        }

        int mid = lists.length / 2;

        ListNode leftList = new ListNode(0, mergeKLists(Arrays.copyOfRange(lists, 0, mid)));
        ListNode rightList = mergeKLists(Arrays.copyOfRange(lists, mid, lists.length));

        ListNode combinedList = leftList;
        while (leftList.next != null || rightList != null) {
            if (rightList != null && (leftList.next == null || leftList.next.val > rightList.val)) {
                ListNode temp = leftList.next;
                leftList.next = rightList;
                rightList = rightList.next;
                leftList.next.next = temp;
            } else {
                leftList = leftList.next;
            }
        }
        return combinedList.next;
    }
}
