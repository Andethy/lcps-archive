package nc.sliding.window;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">Best Time to Buy and Sell Stock</a>
 */
class Solution121 {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, max = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                max = Math.max(max, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }
}