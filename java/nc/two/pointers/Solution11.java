package nc.two.pointers;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water">Container With Most Water</a>
 */
class Solution11 {
    public int maxArea(int[] height) {
        int front = 0;
        int back = height.length - 1;
        int max = 0;
        while (front < back) {
            int curr = getArea(height[front], height[back], back - front);
            if (curr > max) {
                max = curr;
            }

            if (height[front] > height[back]) {
                back--;
            } else {
                front++;
            }
        }
        return max;
    }

    private int getArea(int a, int b, int diff) {
        return Math.min(a, b) * diff;
    }
}
