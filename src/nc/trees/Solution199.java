package nc.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view">Binary Tree Right Side View</a>
 */
class Solution199 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recurse(root, list, 0);
        return list;
    }

    private void recurse(TreeNode curr, List<Integer> list, int level) {
        if (curr != null) {
            if (list.size() == level) {
                list.add(curr.val);
            }
            recurse(curr.right, list, level + 1);
            recurse(curr.left, list, level + 1);
        }
    }
}
