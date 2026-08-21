class Solution {
    int[] visited;
    int[] pathVisited;
    List<Integer> order;
    public int[] findOrder(int N, int[][] edges) {
       List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(v).add(u);
        }
        // code here
        visited = new int[N];
        pathVisited = new int[N];
        order = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
         if(visited[i] == 0){
             if(dfs(i,adj)){
                 return new int[]{};
             }
         }
        }
        int[] ans = new int[N];
        for(int i = 0 ; i < N ; i++){
            ans[i] = order.get(N - i - 1);
        }
       return ans;
     }

     boolean dfs(int idx,List<List<Integer>> adj){
         visited[idx] = 1;
         pathVisited[idx] = 1;
         for(int i : adj.get(idx)){
             if(visited[i] == 1 && pathVisited[i] == 1) return true;
             if(visited[i] == 0 ){
                 if(dfs(i,adj)){
                     return true;
                 }
             }
         }
         pathVisited[idx] = 0;
         order.add(idx);
         return false;
     }
 }
