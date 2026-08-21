class Solution {
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(!bfs(i,graph)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean bfs(int idx,int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        color[idx] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int i : graph[node]){
                if(color[i] == -1){
                    color[i] = 1 - color[node];
                    q.add(i);
                }else if(color[i] == color[node]){
                    return false;
                }
            }
        }
        return true; 
    }
}