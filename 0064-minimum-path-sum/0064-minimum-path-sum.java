class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] opti = new int[m];
        opti[0] = grid[0][0];
        for(int i = 1 ; i < m ; i++){
            opti[i] = grid[0][i] + opti[i - 1]; 
        }
        System.out.println(Arrays.toString(opti));
        for(int i = 1 ; i < n ; i++){
            int[] temp = new int[m];
            temp[0] = opti[0] + grid[i][0];
            for(int j = 1 ; j < m ; j++){
                temp[j] = grid[i][j] + Math.min(opti[j],temp[j - 1]);
            }
            opti = temp;
        }
        System.out.println(Arrays.toString(opti));
        return opti[m-1];
    }
}