package nc.binary.search;

class Solution33B {
    public int search(int[] nums, int target) {

        return binarySearchRotated(nums, target, 0, nums.length - 1);
    }

    private int binarySearchRotated(int[] arr, int target, int front, int back) {
        // System.out.println(front + " | " + back);
        if (front > back) {
            return -1;
        }

        int mid = (front + back) / 2;
        // System.out.println(mid);

        if (arr[mid] == target) {
            return mid;
        } else if (arr[front] <= arr[mid]) {
            if (target > arr[mid] || target < arr[front]) {
                front = mid + 1;
            } else {
                back = mid - 1;
            }

        } else {
            if (target < arr[mid] || target > arr[back]) {
                back = mid - 1;
            } else {
                front = mid + 1;
            }
        }
        return binarySearchRotated(arr, target, front, back);
    }
}
