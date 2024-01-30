package nc.trees;

public class Solution297A {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // String result = "BT,1";
            StringBuilder result = new StringBuilder("BT ");

            serializeH(root, result);

            // System.out.println(result);

            return result.substring(0, result.length() - 1);
        }

        private void serializeH(TreeNode curr, StringBuilder result) {
            if (curr != null) {
                result.append(curr.val + " ");
                serializeH(curr.left, result);
                serializeH(curr.right, result);
            } else {
                result.append("X ");
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(" ");
            if (arr[1].equals("X")) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(arr[1]));
            deserializeH(root, arr, new TreeNode(2));
            return root;
        }

        private void deserializeH(TreeNode curr, String[] arr, TreeNode dummy) {
            if (dummy.val + 1 >= arr.length) {
                return;
            }

            if (!arr[dummy.val].equals("X")) {
                curr.left = new TreeNode(Integer.parseInt(arr[dummy.val++]));
                deserializeH(curr.left, arr, dummy);
            } else {
                ++dummy.val;
            }

            if (!arr[dummy.val].equals("X")) {
                curr.right = new TreeNode(Integer.parseInt(arr[dummy.val++]));
                deserializeH(curr.right, arr, dummy);
            } else {
                ++dummy.val;
            }
        }
    }
}
