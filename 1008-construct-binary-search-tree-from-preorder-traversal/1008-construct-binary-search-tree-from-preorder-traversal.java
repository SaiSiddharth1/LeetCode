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
        TreeNode head = new TreeNode(preorder[0]);
        for(int i = 1 ; i < preorder.length ; i++){
            insert(preorder[i],head);
        }
        return head;
    }

    void insert(int x,TreeNode head){
        TreeNode temp = head;
        while(true){
            if(temp.val > x){
                if(temp.left == null){
                    temp.left = new TreeNode(x);
                    return;
                }
                temp = temp.left;
            }
            else{
                if(temp.right == null){
                    temp.right = new TreeNode(x);
                    return;
                }
                temp = temp.right;
            }
        }
    }

}