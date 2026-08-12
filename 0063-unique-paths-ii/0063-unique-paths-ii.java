class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int m = o.length;
        int n = o[0].length;
        if(o[0][0] == 1 || o[m - 1][n - 1] == 1) return 0;
        o[0][0] = 1;
        for(int i = 1 ; i < m ; i++){
            if(o[i][0] == 1){
                o[i][0] = 0;
                continue;
            }
            o[i][0] = o[i - 1][0];
        }
        for(int i = 1 ; i < n ; i++){
            if(o[0][i] == 1){
                o[0][i] = 0;
                continue;
            }
            o[0][i] = o[0][i - 1];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(o[i][j] == 1){
                    o[i][j] = 0;
                    continue;
                }
                o[i][j] = o[i-1][j] + o[i][j-1];
            }
        }
        return o[m-1][n-1];
    }
}
