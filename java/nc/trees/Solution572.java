package nc.trees;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">Subtree of Another Tree</a>
 */
class Solution572 {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean attempt = subRoot == null;
        if (root == null) {
            return attempt;
        } else if (root.val == subRoot.val) {
            attempt = potentialSubSearch(root, subRoot);
        }
        return attempt || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean potentialSubSearch(TreeNode tree, TreeNode subTree) {
        if (tree == null && subTree == null) {
            return true;
        } else if (tree == null || subTree == null || tree.val != subTree.val) {
            return false;
        } else {
            return potentialSubSearch(tree.left, subTree.left) && potentialSubSearch(tree.right, subTree.right);
        }
    }
}
