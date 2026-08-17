class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int c = 0;
        visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true;
                c++;
                bfs(i,isConnected);
            }
        }
        return c;
    }

    void bfs(int x,int[][] isConnected){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int xx = q.remove();
            for(int i = 0 ; i < isConnected.length ; i++ ){
                if(isConnected[xx][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}