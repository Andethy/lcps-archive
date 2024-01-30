package nc.binary.search;

/**
 * <a href="https://leetcode.com/problems/binary-search">Binary Search</a>
 */
class Solution704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int front, int back) {
        int mid = (front + back) / 2;
        if (front > back) {
            return -1;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, back);
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, front, mid - 1);
        } else {
            return mid;
        }
    }
}
