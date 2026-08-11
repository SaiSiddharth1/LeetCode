class Solution {
    int[] nums1;
    int[] nums2;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        nums1 = nums;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            s.add(nums[i]);
        }
        int m = s.size();
        nums2 = new int[m];
        int idx = 0;
        for(int i : s){
            this.nums2[idx++] = i;
        }
        dp = new int[n + 1][m + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);

        return solve(n,m);
    }
    int solve(int i,int j){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(nums1[i - 1] == nums2[j - 1]){
            return dp[i][j] = 1 + solve(i-1,j-1);
        }
        int op1 = solve(i-1,j);
        int op2 = solve(i,j-1);
        return dp[i][j] = Math.max(op1,op2);
    }
}