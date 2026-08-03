class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = min(coins,n - 1 , amount,dp);
        return ans;
    }
    int min(int[] coins,int idx , int t,int[][] dp){
        if(idx == 0){
            if(t % coins[0] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[idx][t] != -1) return dp[idx][t];
        int notTake = min(coins,idx - 1,t,dp);
        int take = 0;
        if(coins[idx] <= t){
            take = min(coins,idx,t - coins[idx],dp);
        }
        return dp[idx][t] = take + notTake;
    }
}