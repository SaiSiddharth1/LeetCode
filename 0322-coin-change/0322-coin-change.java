class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] tabu = new int[n][amount + 1];
        for(int t = 0 ; t <= amount ; t++){
            if(t % coins[0] == 0) tabu[0][t] = t / coins[0];
            else tabu[0][t] = (int) 1e8;
        }

        for(int idx = 1 ; idx < n ; idx++){
            for(int target = 0 ; target <= amount ; target++){
                int nT = tabu[idx - 1][target];
                int t = (int) 1e8;
                if(coins[idx] <= target){
                    t = 1 + tabu[idx][target - coins[idx]];
                }
                tabu[idx][target] = Math.min(t,nT);
            }
        }  
        int ans = tabu[n-1][amount];
        return (ans == (int) 1e8) ? -1 : ans;
    }
}