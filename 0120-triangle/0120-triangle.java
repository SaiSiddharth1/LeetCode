class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        Integer[][] dp = new Integer[row][col];
        return solve(0,0,row,col,triangle,dp);
    }

    int solve(int i,int j,int r,int c,List<List<Integer>> t,Integer[][] dp){
        if(i >= r || j >= c) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int d = solve(i+1,j,r,c,t,dp);
        int dr = solve(i+1,j + 1,r,c,t,dp);
        return dp[i][j] = t.get(i).get(j) + Math.min(d,dr);
    }
}