package binary.search.tree;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution98B {
    private static class TreeNode {
        int val;
        Solution98B.TreeNode left;
        Solution98B.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Solution98B.TreeNode left, Solution98B.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Queue<Integer> queue = new ArrayDeque<>();
        try {
            inorder(root, queue);
            return true;
        } catch (RuntimeException e) {
            return false;
        }

    }

    private void inorder(TreeNode curr, Queue<Integer> queue) {
        if (curr != null) {
            inorder(curr.left, queue);
            if (queue.peek() != null && queue.remove() >= curr.val) {
                throw new RuntimeException();
            } else {
                queue.add(curr.val);
            }
            inorder(curr.right, queue);
        }
    }
}
