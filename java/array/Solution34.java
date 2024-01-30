package array;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">Find First and Last Position of Element in Sorted Array</a>
 */
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        int existsAt = searchExists(nums, target, 0, nums.length - 1);
        if (existsAt > -1) {
            range[0] = findBounds(nums, target, true, 0, existsAt);
            range[1] = findBounds(nums, target, false, existsAt, nums.length - 1);
        }
        return range;
    }

    public int searchExists(int[] arr, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        } else if (arr[mid] < target) {
            return searchExists(arr, target, mid + 1, end);
        } else if (arr[mid] > target) {
            return searchExists(arr, target, start, mid - 1);
        } else {
            return mid;
        }
    }

    public int findBounds(int[] arr, int target, boolean lowerBound, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        } else if (arr[mid] < target) {
            return findBounds(arr, target, lowerBound, mid + 1, end);
        } else if (arr[mid] > target) {
            return findBounds(arr, target, lowerBound, start, mid - 1);
        } else {
            if (lowerBound) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    return findBounds(arr, target, true, start, mid - 1);
                }
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    return findBounds(arr, target, false, mid + 1, end);
                }
            }
        }
    }
}
