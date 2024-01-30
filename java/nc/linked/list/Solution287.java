package nc.linked.list;

class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int curr = nums[0];
        while (curr != slow) {
            curr = nums[curr];
            slow = nums[slow];
        }

        return curr;
    }
}