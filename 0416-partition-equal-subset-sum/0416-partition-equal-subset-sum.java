class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int[][] memo = new int[nums.length][(sum / 2) + 1];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return solve(nums.length - 1,sum/2,nums,memo);
    }

    boolean solve(int idx,int target,int[] nums,int[][] memo){
        if(target == 0) return true;
        if(idx < 0) return false;
        if(memo[idx][target] != -1){
            if(memo[idx][target] == 1) return true;
            return false;
        }
        boolean notTake = solve(idx - 1,target,nums,memo);
        boolean take = false;
        if(nums[idx] <= target){
            take = solve(idx - 1,target - nums[idx],nums,memo);
        }
        boolean ans = notTake || take;
        memo[idx][target] = (ans) ? 1 : 0;
        return ans;
    }
}