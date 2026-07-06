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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int maxLen = 0;
        while(!q.isEmpty()){
            Pair front = q.peek();
            int size = q.size();
            int start = front.idx;
            int end = start;
            for(int i = 0 ; i < size ; i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                end = p.idx;

                if(curr.left != null){
                    q.add(new Pair(curr.left,2 * end + 1));
                }
                if(curr.right != null){
                    q.add(new Pair(curr.right,2 * end + 2));
                }
            }
            maxLen = Math.max(maxLen,end - start + 1);
        }
        return maxLen;
    }
}
class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node = node;
        this.idx = idx;
    }
}