package tree;

class Solution98A {
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
    public boolean isValidBST(TreeNode root) {
        return valHelper(root);

    }

    private boolean valHelper(TreeNode curr) {
        if (curr == null || (curr.left == null && curr.right == null)) {
            return true;
        }

        if (curr.left == null) {
            return getMin(curr.right) > curr.val && valHelper(curr.right);
        } else if (curr.right == null) {
            return getMax(curr.left) < curr.val && valHelper(curr.left);
        } else {
            return getMin(curr.right) > curr.val
                    && getMax(curr.left) < curr.val
                    && valHelper(curr.right)
                    && valHelper(curr.left);
        }
    }

    private int getMax(TreeNode curr) {
        if (curr == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(curr.val, Math.max(getMax(curr.left), getMax(curr.right)));
        }
    }

    private int getMin(TreeNode curr) {
        if (curr == null) {
            return Integer.MAX_VALUE;
        } else {
            return Math.min(curr.val, Math.min(getMin(curr.left), getMin(curr.right)));
        }
    }

}
