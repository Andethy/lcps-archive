package tree;

public class RandomTest {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxAlternatingPath(TreeNode root) {
        return maxH(root, -1);
    }

    private int maxH(TreeNode curr, int val) {
        if (curr == null || curr.val == val) {
            return 0;
        } else {
            return 1 + Math.max(maxH(curr.left, curr.val), maxH(curr.right, curr.val));
        }
    }
}
