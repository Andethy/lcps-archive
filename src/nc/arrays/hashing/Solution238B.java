package nc.arrays.hashing;

/**
 * Note: much better solution
 * Time complexity: O(n)
 * Space complexity: O(n) (O(1) additional space)
 */
class Solution238B {
    public int[] productExceptSelf(int[] nums) {
        int sz = nums.length;
        int[] arr = new int[sz];
        int[] right = new int[sz];
        arr[0] = 1;
        for (int n = 1; n < sz; n++) {
            arr[n] = arr[n - 1] * nums[n - 1];
        }
        int rightProd = 1;
        for (int n = sz - 2; n >= 0; n--) {
            rightProd *= nums[n + 1];
            arr[n] *= rightProd;
        }
        return arr;
    }
}
