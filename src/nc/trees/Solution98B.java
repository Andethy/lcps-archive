package nc.trees;

class Solution98B {
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

    public boolean isValidBST(TreeNode root) {
        return traverse(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }

    public boolean traverse(TreeNode curr, long left, long right) {
        if (curr == null) {
            return true;
        }
        long val = curr.val;
        if ( val <= left || val >= right) {
            return false;
        }
        return traverse(curr.left, left, curr.val) && traverse(curr.right, curr.val, right);
    }
}
