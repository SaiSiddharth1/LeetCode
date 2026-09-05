/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null;   // first wrong node
    TreeNode second = null;  // second wrong node
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        // swap values back
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // detect violation
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;   // first violation: grab prev
            second = node;                     // always update second
        }
        prev = node;

        inorder(node.right);
    }
}