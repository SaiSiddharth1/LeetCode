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
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) return null;
        return bst(preorder,Integer.MAX_VALUE);
    }
    TreeNode bst(int[] arr,int bound){
        if(idx == arr.length || arr[idx] > bound) return null;
        TreeNode root = new TreeNode(arr[idx]);
        idx++;
        root.left = bst(arr,root.val);
        root.right = bst(arr,bound);
        return root;
    }
}