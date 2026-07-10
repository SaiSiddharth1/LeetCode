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
    public void flatten(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        preOrder(root,ls);
        for(int i = 1 ; i < ls.size() ; i++){
            root.left = null;
            root.right = new TreeNode(ls.get(i));
            root = root.right;
        }
    }

    void preOrder(TreeNode root,List<Integer> ls){
        if(root == null) return;
        ls.add(root.val);
        preOrder(root.left,ls);
        preOrder(root.right,ls);
    }
}