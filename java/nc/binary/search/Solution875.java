package nc.binary.search;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas">Koko Eating Bananas</a>
 */
class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int n = 1; n < piles.length; n++) {
            max = Math.max(max, piles[n]);
        }
        return binarySearch(piles, h, 1, max);
    }

    private int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return start;
        }

        int t = 0;
        int mid = (start + end) / 2;

        for (int n : arr) {
            t += Math.ceil((double) n / mid);
        }

        return t > target ? binarySearch(arr, target, mid + 1, end) : binarySearch(arr, target, start, mid - 1);
    }
}
