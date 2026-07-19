class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int target = (sum / 2);
        boolean[] opti = new boolean[target + 1];

        opti[0] = true;
        if(nums[0] <= target){
            opti[nums[0]] = true;
        }
        for(int i = 1 ; i < nums.length ; i++){
            boolean[] curr = new boolean[target + 1];
            for(int j = 1 ; j < target + 1 ; j++){
                boolean nT = opti[j];
                boolean t = false;
                if(nums[i] <= j){
                    t = opti[j - nums[i]];
                }
                curr[j] = nT || t;
            }
            opti = curr;
        }
        return opti[target];
    }
}