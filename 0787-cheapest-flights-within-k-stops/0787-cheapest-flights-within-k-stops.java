class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < flights.length ; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new int[]{v,wt});
        }

        TreeSet<int[]> pq = new TreeSet<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            else if(a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[2],b[2]);
        });
        pq.add(new int[]{0,0,src});

        int[][] dist = new int[n][k + 2];

        for(int[] arr : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.pollFirst();
            int wt = curr[0];
            int stop = curr[1];
            int node = curr[2];
            if(wt > dist[node][stop]) continue;
            if(node == dst){
                return wt;
            }
            if(stop == k + 1) continue;

            for(int[] neighbour : adj.get(node)){
                int neighbourNode = neighbour[0]; 
                int neighbourWt = neighbour[1]; 
                int newWt = wt + neighbourWt;
                int newStop = stop + 1;
                if(newWt < dist[neighbourNode][newStop]){
                    dist[neighbourNode][newStop] = newWt;
                    pq.add(new int[]{newWt,newStop,neighbourNode});
                }
            }
        }
        return -1;
    }
}