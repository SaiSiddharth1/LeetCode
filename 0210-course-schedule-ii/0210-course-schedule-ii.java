class Solution {
    public int[] findOrder(int n, int[][] p) {
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());    
        }

        for(int i = 0 ; i < p.length ; i++){
            int u = p[i][0];
            int v = p[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int c = 0;
        int[] ans = new int[n];
        while(!q.isEmpty()){
            int node = q.remove();
            ans[c] = node;
            c++;
            for(int x : adj.get(node)){
                indegree[x]--;
                if(indegree[x] == 0){
                    q.add(x);
                }
            }
        }
        if(c == n) return ans;
        return new int[]{};
    }
}