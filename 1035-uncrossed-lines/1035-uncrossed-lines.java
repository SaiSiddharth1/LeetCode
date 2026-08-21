class Solution {
    int[][] memo;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        memo = new int[n][m];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return solve(n-1,m-1,nums1,nums2);
    }

    int solve(int i,int j,int[] nums1,int[] nums2){
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(nums1[i] == nums2[j]){
            return memo[i][j] =  1 + solve(i-1,j-1,nums1,nums2);
        }
        int l = solve(i-1,j,nums1,nums2);
        int r = solve(i,j-1,nums1,nums2);
        return memo[i][j] =  Math.max(l,r);
    }
}