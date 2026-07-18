class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UFDS ds = new UFDS(n);
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            ds.union(u,v);
        }
        return ds.find(source) == ds.find(destination);
    }
}

class UFDS{
    int islands;
    int n;
    int[] parent;
    public UFDS(int n){
        this.n = n;
        this.islands = n;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    boolean union(int x,int y){
        int leaderX = find(x);
        int leaderY = find(y);
        if(leaderY == leaderX){
            return false;
        }
        parent[leaderY] = leaderX;
        islands--;
        return true;
    }
}