class Solution {
    int n,m;
    int[][] visited;
    int[] dx = {0,-1,0,1};
    int[] dy = {-1,0,1,0};
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1){ 
                        visited[i][j] = 1;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            for(int d = 0 ; d < 4 ; d++){
                int newX = x + dx[d];
                int newY = y + dy[d];
                if(check(newX,newY)&& visited[newX][newY] == 0){
                    if(grid[newX][newY] == 1){
                        visited[newX][newY] = 1;
                        q.add(new int[]{newX,newY});
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(visited));
        int c = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0) c++;
            }
        }
        return c;
    }
    boolean check(int x,int y){
        return (x >=0 && y >= 0 && x < n && y < m);
    }
}