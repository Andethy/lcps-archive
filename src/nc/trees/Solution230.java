package nc.trees;

class Solution230 {
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
    
    int count;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode kSmallest = new TreeNode();
        traverse(root, kSmallest, k);
        return kSmallest.val;
    }

    private void traverse(TreeNode curr, TreeNode val, int k) {
        if (curr != null) {
            traverse(curr.left, val, k);
            if (++count == k) {
                val.val = curr.val;
                return;
            }
            traverse(curr.right, val, k);
        }
    }
}
