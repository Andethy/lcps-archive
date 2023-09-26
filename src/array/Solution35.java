package array;

/**
 * <a href="https://leetcode.com/problems/search-insert-position">Search Insert Position</a>
 */
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public int searchHelper(int[] arr, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return start;
        } else if (arr[mid] < target) {
            return searchHelper(arr, target, mid + 1, end);
        } else if (arr[mid] > target) {
            return searchHelper(arr, target, start, mid - 1);
        } else {
            return mid;
        }
    }
}
