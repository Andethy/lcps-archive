package array;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array">Search in Rotated Sorted Array</a>
 */
class Solution33 {
    public int search(int[] nums, int target) {
        int min = searchForMin(0, nums, 0, nums.length - 1);
        return binarySearchMod(nums, target, min, min - 1 + nums.length);
    }

    private int searchForMin(int lowestIndex, int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return lowestIndex;
        } else if (nums[mid] <= nums[lowestIndex]){
            int s1 = searchForMin(mid, nums, mid + 1, end);
            int s2 = searchForMin(mid, nums, start, mid - 1);
            return nums[s1] > nums[s2] ? s2 : s1;
        } else if (nums[mid] > nums[lowestIndex]) {
            return searchForMin(lowestIndex, nums, mid + 1, end);
        }
        return lowestIndex;
    }

    private int binarySearchMod(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        int midMod = getMod(mid, nums.length);
        if (start > end) {
            return -1;
        } else if (nums[midMod] > target) {
            return binarySearchMod(nums, target, start, mid - 1);
        } else if (nums[midMod] < target) {
            return binarySearchMod(nums, target, mid + 1, end);
        } else {
            return midMod;
        }
    }

    private int getMod(int a, int b) {
        int c = a % b;
        return c < 0 ? c + b : c;
    }
}
