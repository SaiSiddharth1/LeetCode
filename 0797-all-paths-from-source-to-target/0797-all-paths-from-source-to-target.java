class Solution {
    List<List<Integer>> ans; 
    List<List<Integer>> adj;
    int[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int V = graph.length;
        adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < V ; i++){
            for(int x : graph[i]){
                adj.get(i).add(x);
            }
        }
        visited = new int[V];
        ans = new ArrayList<>();
        for(int i : adj.get(0)){
            List<Integer> ls = new ArrayList<>();
            ls.add(0);
            if(visited[i] == 0){
                dfs(i,ls,V-1);
            }
        }
        return ans;
    }

    void dfs(int node,List<Integer> ls,int LastNode){
        ls.add(node);
        visited[node] = 1;
        if(LastNode == node){
            ans.add(new ArrayList<>(ls));
        }else{
            for(int neighbour : adj.get(node)){
                if(visited[neighbour] == 0){
                    dfs(neighbour,ls,LastNode);
                }
            }
        }
        visited[node] = 0;
        ls.remove(ls.size() - 1);
    }
}