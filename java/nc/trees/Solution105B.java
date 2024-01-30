package nc.trees;

import java.util.HashMap;
import java.util.Map;

class Solution105B {

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < inorder.length; n++) {
            map.put(inorder[n], n);
        }

        return buildTreeHelper(preorder, map, 0, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> map, int curr, int left, int right) {
        if (left > right || curr >= preorder.length) {
            return null;
        }

        int mid = map.get(preorder[curr]);
        TreeNode root = new TreeNode(preorder[curr]);
        root.left = buildTreeHelper(preorder, map, curr + 1, left, mid - 1);
        root.right = buildTreeHelper(preorder, map, curr - left + mid + 1, mid + 1, right);
        return root;
    }
}
