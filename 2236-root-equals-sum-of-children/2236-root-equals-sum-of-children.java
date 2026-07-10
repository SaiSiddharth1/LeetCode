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
    public boolean checkTree(TreeNode root) {
        TreeNode temp = root;
        return check(temp);
    }

    public boolean check(TreeNode temp){
        int val = temp.val;
        int l = 0, r = 0;
        if(temp.left != null) l = temp.left.val;
        if(temp.right != null) r = temp.right.val;
        if(val != l + r) return false;
        if(temp.left != null) temp = temp.left;
        if(temp.right != null) temp = temp.right;
        return true;
    }
}