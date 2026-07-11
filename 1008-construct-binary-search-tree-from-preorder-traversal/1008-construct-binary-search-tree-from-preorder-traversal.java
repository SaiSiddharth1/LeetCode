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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) return null;
        return bst(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    TreeNode bst(int[] arr,int bound,int[] idx){
        if(idx[0] == arr.length || arr[idx[0]] > bound) return null;
        TreeNode root = new TreeNode(arr[idx[0]++]);
        root.left = bst(arr,root.val,idx);
        root.right = bst(arr,bound,idx);
        return root;
    }
}