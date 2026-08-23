class Solution {
    int[] visited;
    int[] pathVisited;
    int[] check;
    List<List<Integer>> adj;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
            for(int x : graph[i]){
                adj.get(i).add(x);
            }
        }
        List<Integer> safe;
        visited = new int[n];
        pathVisited = new int[n];
        check = new int[n];
        safe = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(check[i] == 1){
                safe.add(i);
            }
        }
        // Collections.reverse(order);
        return safe;
    }

    boolean dfs(int i){
        visited[i] = 1;
        pathVisited[i] = 1;
        for(int x : adj.get(i)){
            if(visited[x]==1 && pathVisited[x] == 1){
                return true;
            }
            if(visited[x]==0){
                if(dfs(x)) return true;
            }
        }
        pathVisited[i] = 0;
        check[i] = 1;
        return false;
    }
}