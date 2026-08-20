class Solution {
    int n,m;
    int[][] visited;
    int[] dx = {0,-1,0,1};
    int[] dy = {-1,0,1,0};
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];

        for(int j = 0 ; j < m  ; j++){
            if(grid[0][j] == 1){
                dfs(0,j,grid);
            }
            if(grid[n-1][j] == 1){
                dfs(n-1,j,grid);
            }
        }
        for(int i = 1 ; i < n-1  ; i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
            if(grid[i][m-1] == 1){
                dfs(i,m-1,grid);
            }
        }
        int sum = 0;
        for(int[] arr : grid){
            for(int i : arr){
                sum += i;
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return sum;
    }

    void dfs(int x,int y,int[][] grid){
        visited[x][y] = 1;
        grid[x][y] = 0;
        for(int d = 0 ; d < 4 ; d++){
            int newX = x + dx[d];
            int newY = y + dy[d];
            if(check(newX,newY) && visited[newX][newY] == 0){
                if(grid[newX][newY] == 1){
                    dfs(newX,newY,grid);
                }
            }
        }
    }

    boolean check(int x,int y){
        return (x >=0 && y >= 0 && x < n && y < m);
    }
}