class Solution {
    boolean[] visited;
    int c = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            List<Integer> ls = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    ls.add(j+1);
                }
            }
            adj.set(i+1,ls);
        }
        visited = new boolean[n+1];
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i <= n ;i++) {
            if(!visited[i]) {
                c++;
                visited[i] = true;
                dfs(i,adj,ans);
            }
        }
        return c;
    }
    void dfs(int x,List<List<Integer>> adj,List<Integer> ans){
        ans.add(x);
        for(int i : adj.get(x)){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,adj,ans);
            }
        }
    }
}