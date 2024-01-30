package nc.trees;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * Note: bad solution
 */
class Solution105A {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int location = 0;
        while (inorder[location] != preorder[0]) {
            location++;
        }

        TreeNode curr = new TreeNode(preorder[0]);
        curr.left = buildTree(Arrays.copyOfRange(preorder, 1, location + 1),
                Arrays.copyOfRange(inorder, 0, location));
        curr.right = buildTree(Arrays.copyOfRange(preorder, location + 1, preorder.length),
                Arrays.copyOfRange(inorder, location + 1, inorder.length));
        return curr;
    }
}
