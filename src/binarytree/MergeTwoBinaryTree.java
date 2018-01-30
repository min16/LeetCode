package binarytree;
/*
    Problem 617
 */
public class MergeTwoBinaryTree {
    public class TreeNode {
        int val;*
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        int val = t1.val + t2.val;
        TreeNode newNode = new TreeNode(val);

        if (t1.left != null || t2.left != null) {
            newNode.left = merge(t1.left, t2.left);
        }

        if (t1.right != null || t2.right != null) {
            newNode.right = merge(t1.right, t2.right);
        }

        return newNode;
    }
}
