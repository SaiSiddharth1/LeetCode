class Solution {
    int[][] visited;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid[0].length;
        visited = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                visited[i][j] = grid[i][j];
            }
        }
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = 1;
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] curr = q.remove();
                int x = curr[0];
                int y = curr[1];
                if(x == n - 1 && y == m - 1){
                    return level;
                }
                for(int d = 0 ; d < 8 ; d++){
                    int newX = dx[d] + x;
                    int newY = dy[d] + y;
                    if(check(newX,newY,n,m) && visited[newX][newY] == 0){
                        visited[newX][newY] = 1;
                        q.add(new int[]{newX,newY});
                    }
                }
            }
        }
        return -1;
    }

    boolean check(int x,int y,int n,int m){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}