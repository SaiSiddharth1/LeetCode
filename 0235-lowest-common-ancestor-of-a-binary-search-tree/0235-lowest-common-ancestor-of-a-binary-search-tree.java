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
        if((val >= q.val && val <= p.val) || (val >= p.val && val <= q.val)) return root;
        TreeNode l = search(root.left,p,q);
        TreeNode r = search(root.right,p,q);
        if(l == null) return r;
        else if(r == null) return l;
        return root;
    }
}