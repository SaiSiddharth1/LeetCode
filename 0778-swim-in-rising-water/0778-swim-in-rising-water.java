class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        visited[0][0] = true;
        int max = 0;
        pq.add(new int[]{grid[0][0],0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];
            max = Math.max(time,max);
            if(x == n-1 && y == m - 1) return max;
            for(int d = 0 ; d < 4 ; d++){
                int newX = dx[d] + x;
                int newY = dy[d] + y;
                if(check(newX,newY,n,m) && !visited[newX][newY]){
                    int newTime = Math.max(time, grid[newX][newY]);
                    visited[newX][newY] = true;
                    pq.add(new int[]{newTime,newX,newY});
                }
            }
        }
        return 0;
    }

    boolean check(int x,int y,int n,int m){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}