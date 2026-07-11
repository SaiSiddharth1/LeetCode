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
    public boolean isValidBST(TreeNode root) {
        if(root == null || ((root.left == null) && (root.right == null))) return true;
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    boolean check(TreeNode curr,long min,long max){
        if(curr == null) return true;
        if(curr.val <= min || curr.val >= max) return false;
        return check(curr.left,min,curr.val) && check(curr.right,curr.val,max);
    }
}