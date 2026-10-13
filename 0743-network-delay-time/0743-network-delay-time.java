class Solution {
    public int networkDelayTime(int[][] times, int n, int via) {
        int INF = (int) 1e9;
        int[][] dist = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i == j){
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        for(int[] arr : times){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            dist[u][v] = wt; 
        }

        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(dist[via][i] == INF) return -1;
            ans = Math.max(ans,dist[via][i]);
        }
        return ans;
    }
}