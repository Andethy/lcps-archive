package nc.two.pointers;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water">Trapping Rain Water</a>
 */
class Solution42A {
    public int trap(int[] height) {
        int total = 0;
        int h1 = 0;
        int h2 = 0;
        while (h1 < height.length - 1 && height[h1] == 0) {
            h1++;
        }
        h2 = h1;
        int currMin = height[h1];
        // System.out.println("new heights: " + h1 + " | " + h2);
        for (int n = h1; n < height.length - 1; n++) {
            if (n == h2) {
                h1 = h2;
                int h3 = h2 + 1;
                do  {
                    h2++;
                    if (height[h2] > height[h3]) {
                        h3 = h2;
                    }
                } while (h2 < height.length - 1 && height[h2] < height[h1]);
                if (h2 == height.length - 1) {
                    h2 = h3;
                }
                currMin = Math.min(height[h1], height[h2]);
                continue;
                // System.out.println("new heights: " + h1 + " | " + h2);
            }
            // System.out.println("adding " + Math.max(0, currMin - height[n]));
            total += Math.max(0, currMin - height[n]);
        }
        return total;
    }
}
