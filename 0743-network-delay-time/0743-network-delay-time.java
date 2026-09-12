class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist,(int) 1e9);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new int[]{v,wt});
        }

        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int wt = curr[0];
            int node = curr[1];
            if(wt > dist[node]) continue;
            for(int[] neighbour : adj.get(node)){
                int nNode = neighbour[0];
                int nWt = neighbour[1];
                if(wt + nWt < dist[nNode]){
                    dist[nNode] = wt + nWt; 
                    pq.add(new int[]{dist[nNode],nNode});
                }
            }
        }
        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            max = Math.max(dist[i],max);
        }
        return (max == (int) 1e9) ? -1 : max; 
    }
}