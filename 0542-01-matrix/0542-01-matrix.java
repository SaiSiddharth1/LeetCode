class Solution {
    int n,m;
    int[][] visited;
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        visited = new int[n][m];
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = 1;
                }
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] curr = q.remove();
                int x = curr[0];
                int y = curr[1];
                int dist = curr[2];
                ans[x][y] = dist;
                for(int d = 0 ; d < 4 ; d++){
                    int newX = x + dx[d];
                    int newY = y + dy[d];
                    if(check(newX,newY) && visited[newX][newY] != 1){
                        visited[newX][newY] = 1;
                        q.add(new int[]{newX,newY,dist + 1});
                    }
                }
            }
        }
        return ans;
    }
    
    boolean check(int i,int j){
        return (i < n && j < m && i >= 0 && j >= 0);
    }
}