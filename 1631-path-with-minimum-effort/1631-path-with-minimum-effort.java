class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] diff = new int[n][m];
        for(int[] arr : diff){
            Arrays.fill(arr,(int) 1e9);
        }
        diff[0][0] = 0;
        TreeSet<int[]> pq = new TreeSet<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            if(a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[2],b[2]);
        });
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.pollFirst();
            int dist = curr[0];
            int x = curr[1];
            int y = curr[2];
            for(int d = 0 ; d < 4 ; d++){
                int newX = dx[d] + x;
                int newY = dy[d] + y;
                if(check(newX,newY,n,m)){
                    int h1 = heights[newX][newY];
                    int h2 = heights[x][y];
                    int newEffort = Math.max(Math.abs(h1-h2),dist);
                    if(newEffort < diff[newX][newY]){
                        if(diff[newX][newY] == (int) 1e9){
                            pq.remove(new int[]{diff[newX][newY],newX,newY});
                        }
                        diff[newX][newY] = newEffort;
                        pq.add(new int[]{newEffort,newX,newY});
                    }   
                }
            }
        }
        return diff[n-1][m-1];
    }

    boolean check(int x,int y,int n,int m){
        return(x >= 0 && x < n && y >= 0 && y < m);
    }
}