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
    private int ans = 0;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        solve(p,q);
        if(ans == -1) return false;
        return true;
    }
    void solve(TreeNode p, TreeNode q){
        if(p == null && q == null){ 
                return; 
        }
        if((p == null && q != null) || (p != null && q == null)){
            ans = -1;
            return;
        }
        if(p.val != q.val) {
            ans = -1;
            return;
        }
        solve(p.left,q.left);
        solve(p.right,q.right);
    }
}