class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int V = p.length;
        for(int i = 0 ; i < V ; i++){
            int u = p[i][0];
            int v = p[i][1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int x : adj.get(i)){
                indegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()) return false;
        int c = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            c++;
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        return c == n;
    }
}