/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        return search(root,p,q);
    }
    TreeNode search(TreeNode root,TreeNode p, TreeNode q){
        if(root == null) return null;
        int val= root.val;
        if(val > q.val && val > p.val){
            return search(root.left,p,q);
        }
        if(val < p.val && val < q.val){
            return search(root.right,p,q);
        }
        return root;
    }
}