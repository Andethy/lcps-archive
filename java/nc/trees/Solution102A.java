package nc.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 */
public class Solution102A {

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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> values = new ArrayList<>();
            traverse(root, 0, values);
            return values;

        }

        private void traverse(TreeNode curr, int level, List<List<Integer>> values) {
            if (curr == null) {
                return;
            } else if (values.size() == level) {
                values.add(new ArrayList<>());
            }

            values.get(level).add(curr.val);
            traverse(curr.left, level + 1, values);
            traverse(curr.right, level + 1, values);
        }
    }
}
