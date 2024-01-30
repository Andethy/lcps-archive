package nc.trees;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 */
class Solution226 {

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

    public TreeNode invertTree(TreeNode root) {
        return invertH(root);
    }

    private TreeNode invertH(TreeNode curr) {
        if (curr == null) {
            return null;
        }

        TreeNode temp = curr.left;
        curr.left = invertH(curr.right);
        curr.right = invertH(temp);
        return curr;
    }
}
