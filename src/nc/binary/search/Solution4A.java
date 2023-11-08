package nc.binary.search;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">Median of Two Sorted Arrays</a>
 */
class Solution4A {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int sum = n1 + n2;
        int half = (sum + 1) / 2;

        boolean even = sum % 2 == 0;

        int start = 0;
        int end = nums1.length;
        double median = 0D;

        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = half - mid1;
            // System.out.println("---");
            // System.out.println(start + " | " + end);
            // System.out.println(mid1 + " | " + mid2);

            int s1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int e1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int s2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int e2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (s1 <= e2 && s2 <= e1) {
                if (even) {
                    median = Math.max(s1, s2) / 2D + Math.min(e1, e2) / 2D;
                } else {
                    median = Math.max(s1, s2);
                }
                break;
            } else if (s1 > e2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }
        return median;
    }
}
