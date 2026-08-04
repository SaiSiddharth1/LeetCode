class Solution {
    int offSet;
    public int findTargetSumWays(int[] nums, int target) {
        // int sum = Arrays.stream(nums).sum();
        // offSet = sum;
        // int[][] memo = new int[nums.length][2 * sum + 1];
        // for(int[] arr : memo){
        //     Arrays.fill(arr,Integer.MIN_VALUE );
        // }
        return countPartitions(nums,target);
    }

    public int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        int x = sum - diff;
        if(x < 0 || x % 2 == 1) return 0;
        int[][] memo = new int[n][x/2 + 1];
        for(int[] arrr : memo){
            Arrays.fill(arrr,-1);
        }
        return solve(arr.length - 1,x/2,arr,memo);
    }
    int mod = (int) 1e9 + 7;
    int solve(int idx,int target,int[] arr,int[][] memo){
        if(idx == 0){
            if(target == 0 && arr[idx] == 0) return 2;
            else if(target == 0 || arr[idx] == target) return 1;
            return 0;
        }
        if(memo[idx][target] != -1) return memo[idx][target];
        int nT = solve(idx - 1,target,arr,memo);
        int t = 0;
        if(arr[idx] <= target){
            t = solve(idx - 1,target - arr[idx],arr,memo);
        }
        return memo[idx][target] = (t + nT) % mod;
    }
}