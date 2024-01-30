package nc.two.pointers;

/**
 * Note: much better solution
 */
class Solution42B {
    public int trap(int[] height) {
        int total = 0;
        int front = 0;
        int back = height.length - 1;

        int mFront = height[front];
        int mBack = height[back];

        while (front < back) {
            if (mFront > mBack) {
                mBack = Math.max(mBack, height[--back]);
                total += mBack - height[back];
            } else {
                mFront = Math.max(mFront, height[++front]);
                total += mFront - height[front];
            }
        }

        return total;
    }
}