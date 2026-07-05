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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        if(root == null) return ans;
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(root,0,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Triple t = q.poll();
                TreeNode curr = t.node;
                int v = t.vertex;
                int l = t.level;
                map.putIfAbsent(v,new TreeMap<>());
                map.get(v).putIfAbsent(l,new PriorityQueue<>());
                map.get(v).get(l).add(curr.val);
                if(curr.left != null){
                    q.add(new Triple(curr.left,v - 1,l + 1));
                }
                if(curr.right != null){
                    q.add(new Triple(curr.right,v + 1,l + 1));
                }
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> lvlEntry : map.values()){
            List<Integer> ls = new ArrayList<>();
            for(PriorityQueue<Integer> pq : lvlEntry.values()){
                while(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }
            ans.add(ls);
        }
        return ans;
    }
}

class Triple{
    TreeNode node;
    int vertex;
    int level;
    Triple(TreeNode node,int vertex,int level){
        this.node = node;
        this.vertex = vertex;
        this.level = level;
    }
}