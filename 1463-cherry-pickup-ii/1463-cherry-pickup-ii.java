class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] memo = new int[n][m][m];
        for(int[][] mat : memo){
            for(int[] arr : mat){
                Arrays.fill(arr,-1);
            }
        }
        return solve(0,0,m-1,n,m,grid,memo);
    }
    int solve(int i,int j1 , int j2,int row,int col,int[][] grid,int[][][] memo){
        if(j1 < 0 || j2 < 0 || j1 > col - 1 || j2 > col - 1) return (int) -1e8;
        if(i == row - 1){
            if(j1 == j2){
                return grid[i][j1]; 
            }
            return grid[i][j1] + grid[i][j2]; 
        }
        if(memo[i][j1][j2] != -1) return memo[i][j1][j2];
        // d is direction
        int max = 0;
        for(int d1 = -1 ; d1 <= 1 ; d1++){
            for(int d2 = -1 ; d2 <= 1 ; d2++){
                if(j1 == j2) max = Math.max(max,grid[i][j1] + solve(i+1,j1 + d1 ,j2 + d2,row,col,grid,memo));
                else max = Math.max(max,grid[i][j1] + grid[i][j2] + solve(i+1,j1 + d1 ,j2 + d2,row,col,grid,memo));
            }
        }
        return memo[i][j1][j2] = max;
    }
}