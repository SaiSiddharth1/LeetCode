class Solution {
    int n,m;
    int[][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,-1,0,1};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        int c = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    visited[i][j] = 1;
                    bfs(i,j,grid);
                    c++;
                }
            }
        }
        return c;
    }

    void bfs(int i,int j,char[][] g){
        g[i][j] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int x  = curr[0];
            int y  = curr[1];

            for(int d = 0 ; d < 4 ; d++){
                int newX = x + dx[d];
                int newY = y + dy[d];
                if(check(newX,newY) && g[newX][newY] == '1'){
                    if(visited[newX][newY] == 0){
                        visited[newX][newY] = 1;
                        g[newX][newY] = '0';
                        q.add(new int[]{newX,newY});
                    }
                }
            }
        }
    }

    boolean check(int i,int j){
        return (i >= 0 && j >= 0 && i < n && j < m);
    }
}