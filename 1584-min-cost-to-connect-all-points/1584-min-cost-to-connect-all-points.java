class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int ithP = Math.abs(points[i][0] - points[j][0]);
                int jthP = Math.abs(points[i][1] - points[j][1]);
                int dist = ithP + jthP;
                edges.add(new Edge(i,j,dist));
            }
        }

        Collections.sort(edges,(e1,e2) ->{
            return e1.w - e2.w;
        });
        int c = 0;
        UFDS ds = new UFDS(n);
        int cost = 0;
        for(Edge e : edges){
            if(ds.merge(e.u,e.v)){
                cost += e.w;
                c++;
            }
            if(c == n - 1) break;
        }
        return cost;
    }
}

class Edge{
    int u;
    int v;
    int w;
    Edge(int u,int v,int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class UFDS{
    int n;
    int[] p;
    int[] sz;
    UFDS(int n){
        this.n = n;
        p = new int[n + 1];
        sz = new int[n + 1];

        for(int i = 0 ; i < n + 1 ; i++){
            p[i] = i;
            sz[i] = 0;
        }
    }
    boolean merge(int x,int y){
        int lx = find(x);
        int ly = find(y);
        if(lx == ly) return false;
        if(lx >= ly){
            p[lx] = ly;
            sz[lx] += sz[ly];
        }
        else{
            p[ly] = lx;
            sz[ly] += sz[lx];
        }
        return true;
    }

    int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]); 
    }
}