package nc.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree">Validate Binary Search Tree</a>
 */
class Solution98A {
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

    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        Queue<Integer> vals = new LinkedList<>();
        traverse(root, vals);
        return valid;
    }

    public void traverse(TreeNode curr, Queue<Integer> vals) {
        if (curr != null) {
            traverse(curr.left, vals);
            if (!vals.isEmpty() && vals.remove() >= curr.val) {
                valid = false;
                return;
            }
            vals.add(curr.val);
            traverse(curr.right, vals);
        }
    }
}
