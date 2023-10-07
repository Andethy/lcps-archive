package nc.two.pointers;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">Two Sum II - Input Array Is Sorted</a>
 */
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;
        while (front < back) {
            int sum = numbers[front] + numbers[back];
            if (sum < target) {
                front++;
            } else if (sum > target) {
                back--;
            } else {
                return new int[]{front + 1, back + 1};
            }
        }
        return new int[2];
    }
}
