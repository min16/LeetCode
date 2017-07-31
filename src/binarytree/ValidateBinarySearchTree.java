package binarytree;

public class ValidateBinarySearchTree {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    public boolean isValidTree(TreeNode root) {
        if (root == null) return true;
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode node, Integer low, Integer high) {
        return (node.val > low || low == null && node.val < high || high == null)
                && isValid(node.left, low, node.val)
                && isValid(node.right, node.val, high);
    }
}
