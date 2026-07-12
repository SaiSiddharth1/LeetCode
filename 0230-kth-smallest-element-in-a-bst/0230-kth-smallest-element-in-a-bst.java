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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        inorder(root,ls,k);
        return ls.get(k-1);
    }
    void inorder(TreeNode root,List<Integer> ls,int k){
        if(root == null) return;
        if(ls.size() == k) return;
        inorder(root.left,ls,k);
        ls.add(root.val);
        inorder(root.right,ls,k);
    }
}