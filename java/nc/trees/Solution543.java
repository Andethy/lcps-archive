package nc.trees;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 */
class Solution543 {

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

    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode maxPath = new TreeNode();
        helper(root, maxPath);
        return maxPath.val;
    }

    private int helper(TreeNode curr, TreeNode max) {
        if (curr == null) {
            return 0;
        }

        int leftHeight = helper(curr.left, max);
        int rightHeight = helper(curr.right, max);
        max.val = Math.max(max.val, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
