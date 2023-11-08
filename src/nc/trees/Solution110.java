package nc.trees;

class Solution110 {

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

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }

    private int helper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int left = helper(curr.left);
        int right = helper(curr.right);
        if (Math.abs(right - left) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
