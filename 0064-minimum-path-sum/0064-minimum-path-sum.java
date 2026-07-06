class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] tabu = new int[n][m];
        tabu[0][0] = grid[0][0];
        for(int i = 1 ; i < n ; i++){
            tabu[i][0] = grid[i][0] + tabu[i - 1][0]; 
        }
        for(int i = 1 ; i < m ; i++){
            tabu[0][i] = grid[0][i] + tabu[0][i - 1]; 
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                tabu[i][j] = grid[i][j] + Math.min(tabu[i-1][j],tabu[i][j - 1]);
            }
        }
        return tabu[n-1][m-1];
    }
}