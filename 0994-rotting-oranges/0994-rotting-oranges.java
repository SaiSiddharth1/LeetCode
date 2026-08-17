class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int o = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) o++;
            }
        }
        if(o == 0) return 0;
        int c = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] curr = q.remove();
                int x = curr[0];
                int y = curr[1];
                for(int dir = 0 ; dir < 4 ; dir++){
                    int newX = x + dx[dir];
                    int newY = y + dy[dir];
                    if(check(n,m,newX,newY) && grid[newX][newY] == 1){
                        grid[newX][newY] = 0;
                        q.add(new int[]{newX,newY});
                    }
                }
            }
            if(!q.isEmpty()) c++;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return c;
    }

    boolean check(int n,int m,int newX,int newY){
        return (newX < n && newX >= 0 && newY < m && newY >= 0);
    }
}