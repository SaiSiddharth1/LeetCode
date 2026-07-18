class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UFDS ds = new UFDS(edges.length);
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!ds.merge(u,v)){
                return new int[]{u,v};
            }
        }
        return new int[]{};
    }
}

class UFDS{
    int n;
    int[] parent;
    public UFDS(int n){
        this.n = n + 1;
        parent = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++){
            parent[i] = i;
        }
    }
    int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    boolean merge(int x,int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY){
            return false;
        }
        parent[parentX] = parentY;
        return true;
    }
}