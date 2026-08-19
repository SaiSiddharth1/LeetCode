class Solution {
    int n,m;
    int[][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new int[n][m];

        for(int j = 0 ; j < m ; j++){
            if(visited[0][j] != 1 && board[0][j] == 'O'){
                dfs(0,j,board);
            }
            if(visited[n-1][j] != 1 && board[n-1][j] == 'O'){
                dfs(n-1,j,board);
            }
        }
        for(int i = 0 ; i < n - 1; i++){
            if(visited[i][0] != 1 && board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(visited[i][m-1] != 1 && board[i][m-1] == 'O'){
                dfs(i,m-1,board);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    void dfs(int i,int j,char[][] b){
        visited[i][j] = 1;
        for(int d = 0 ; d < 4 ; d++){
            int newX = i + dx[d];
            int newY = j + dy[d];
            if(check(newX,newY) && visited[newX][newY] == 0){
                if(b[newX][newY] == 'O'){
                    visited[newX][newY] = 1;
                    dfs(newX,newY,b);
                }
            }
        }
    }
    boolean check(int i,int j){
        return (i >= 0 && j >= 0 && i < n && j < m);
    }
}