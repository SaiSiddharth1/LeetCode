class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] tabu = new int[n][amount + 1];
        for(int i = 0 ; i <= amount ; i++){
            tabu[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for(int idx = 1 ; idx < n ; idx++){
            for(int t = 0 ; t <= amount ; t++){
                int notTake = tabu[idx - 1][t];
                int take = 0;
                if(coins[idx] <= t){
                    take = tabu[idx][t - coins[idx]];
                }
                tabu[idx][t] = take + notTake;
            }
        }
        int ans = tabu[n - 1][amount];
        return ans;
    }
}