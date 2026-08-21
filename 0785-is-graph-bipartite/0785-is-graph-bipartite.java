class Solution {
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(!dfs(i,0,graph)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int idx,int c,int[][] graph){
        color[idx] = c;
        for(int i : graph[idx]){
            if(color[i] == -1){
                if(!dfs(i,1-c,graph)) return false;
            }
            else if(color[idx] == color[i]) return false;
        }
        return true; 
    }
}