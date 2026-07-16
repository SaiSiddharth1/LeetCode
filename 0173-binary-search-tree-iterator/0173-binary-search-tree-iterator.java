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
class BSTIterator {

    ArrayList<Integer> ls = new ArrayList<>();
    int idx = -1;
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        ls.add(root.val);
        inorder(root.right);
    }
    public int next() {
        idx++;
        return ls.get(idx);
    }
    
    public boolean hasNext() {
        return (idx < ls.size() - 1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */