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
    public TreeNode sortedArrayToBST(int[] nums) {
       if(nums == null) return null;
       return createBST(nums,0,nums.length - 1);
    }
    TreeNode createBST(int[] nums,int s,int e){
        if(s > e) return null;
        int mid = s + (e - s)/2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = createBST(nums,s,mid - 1);
        head.right = createBST(nums,mid + 1,e);
        return head;
    }
}