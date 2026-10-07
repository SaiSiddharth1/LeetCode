class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int mod = (int) 1e9 + 7;
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            long wt = road[2];
            adj.get(u).add(new long[]{wt,v});
            adj.get(v).add(new long[]{wt,u});
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return Long.compare(a[0],b[0]);
            }
            return Long.compare(a[1],b[1]);
        });
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.remove();
            long wt = curr[0]; 
            int node = (int) curr[1];
            for(long[] neighbours : adj.get(node)){
                long nWt = neighbours[0];
                int nN = (int) neighbours[1];
                if(wt + nWt < dist[nN]){
                    dist[nN] = wt + nWt;
                    pq.add(new long[]{dist[nN],nN});
                    ways[nN] = ways[node];
                }else if(wt + nWt == dist[nN]){
                    ways[nN] = (int) ((long) ways[nN] + ways[node]) % mod;
                }
            } 
        }
        return ways[n - 1];
    }
}