class Solution {
    int[][] tabu;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        tabu = new int[n + 1][m + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    tabu[i][j] =  1 + tabu[i-1][j-1];
                    continue;
                }
                int l = tabu[i-1][j];
                int r = tabu[i][j-1];
                tabu[i][j] =  Math.max(l,r);
            }
        }
        return tabu[n][m];
    }
}