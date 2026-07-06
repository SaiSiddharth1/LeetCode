class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return solve(n-1,m-1,grid,memo);
    }

    int solve(int row,int col,int[][] mat,int[][] memo){
        if(row == 0 && col == 0) return mat[0][0];
        if(row < 0 || col < 0) return (int) 1e7;
        if(memo[row]
        [col] != -1) return memo[row][col];
        int left =  solve(row,col - 1 ,mat,memo) + mat[row][col];
        int up = solve(row - 1,col,mat,memo) + mat[row][col];
        return memo[row][col] = Math.min(left,up);
    }

}