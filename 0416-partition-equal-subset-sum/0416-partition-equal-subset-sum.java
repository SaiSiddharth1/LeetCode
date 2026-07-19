class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int target = (sum / 2);
        boolean[][] tabu = new boolean[nums.length][target + 1];
        for(int i = 0 ; i < nums.length ; i++){
            tabu[i][0] = true;
        }
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 1 ; j < target + 1 ; j++){
                boolean nT = tabu[i - 1][j];
                boolean t = false;
                if(i - 1 >= 0 && j - nums[i] >= 0){
                    t = tabu[i - 1][j - nums[i]];
                }
                tabu[i][j] = nT || t;
            }
        }
        return tabu[nums.length - 1][sum/2];
    }
}