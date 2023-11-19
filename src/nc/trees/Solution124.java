package nc.trees;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum">Binary Tree Maximum Path Sum</a>
 */
class Solution124 {

    public class TreeNode {
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

    int candidateMax;

    public int maxPathSum(TreeNode root) {

        candidateMax = root.val;
        helper(root);
        return candidateMax;
    }

    private int helper(TreeNode curr) {

        int leftBranch = curr.left == null ? Integer.MIN_VALUE : Math.max(helper(curr.left), curr.left.val);
        int rightBranch = curr.right == null ? Integer.MIN_VALUE : Math.max(helper(curr.right), curr.right.val);
        int maxBranches = Math.max(leftBranch, 0) + Math.max(rightBranch, 0);

        candidateMax = Math.max(candidateMax, maxBranches + curr.val);
        return Math.max(Math.max(leftBranch, rightBranch), 0) + curr.val;
    }
}
