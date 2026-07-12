class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] tabu = new int[n][m][m];
        for(int j1 = 0 ; j1 < m ; j1++){
            for(int j2 = 0 ; j2 < m ; j2++){
                if(j1 == j2) tabu[n-1][j1][j2] = grid[n-1][j1];
                else tabu[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2] ;
            }
        }

        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j1 = 0 ; j1 < m ; j1++){
                for(int j2 = 0 ; j2 < m ; j2++){
                    int max = (int) -1e8;
                    for(int d1 = -1 ; d1 <= 1 ; d1++){
                        for(int d2 = -1 ; d2 <= 1 ; d2++){
                            int val = 0;
                            if(j1 == j2) val = grid[i][j1];
                            else val = grid[i][j1] + grid[i][j2];
                            if(j1 + d1 >= 0 && j2 + d2 >= 0 && j1 + d1 < m && j2 + d2 < m) 
                                val += tabu[i+1][j1 + d1][j2 + d2];
                            else val += (int) -1e8;    
                            max = Math.max(max,val);
                        }
                    }
                    tabu[i][j1][j2] = max;
                }
            }   
        }

        return tabu[0][0][m-1];
    }
}