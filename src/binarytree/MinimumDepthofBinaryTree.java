package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Depth First Traversal
    public int minDepthDFT(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepthDFT(root.right) + 1;
        if (root.right == null) return minDepthDFT(root.left) + 1;
        return Math.min(minDepthDFT(root.left), minDepthDFT(root.right)) + 1;
    }

    // Breadth First Traversal
    public int minDepthBFT(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightMost = root;

        int depth = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null) break;
            if (node.left == null) q.add(node.right);
            if (node.right == null) q.add(node.left);
            if (node == rightMost) {
                depth++;
                rightMost =  (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }
}
