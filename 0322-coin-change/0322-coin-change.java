class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n][amount + 1];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        int ans = solve(n - 1,amount,coins,memo);
        return (ans == (int) 1e8) ? -1 : ans;
    }

    public int solve(int idx,int target,int[] arr,int[][] memo){
        if(idx == 0){
            if(target % arr[idx] == 0){
                return target / arr[idx];
            }
            return (int) 1e8;
        }
        if(memo[idx][target] != -1) return memo[idx][target]; 
        int nT = solve(idx - 1,target,arr,memo);
        int t = (int) 1e8;
        if(arr[idx] <= target){
            t = 1 + solve(idx,target - arr[idx],arr,memo);
        }
        return memo[idx][target] = Math.min(t,nT);
    }
}