class Solution {
    int[][] tabu;
    public int lengthOfLIS(int[] nums1) {
        Set<Integer> s = new TreeSet<>();
        for(int i : nums1){
            s.add(i);
        }
        int x = 0;
        int[] nums2 = new int[s.size()];
        for(int i : s){
            nums2[x++] = i; 
        }
        int n = nums1.length;
        int m = nums2.length;
        tabu = new int[n + 1][m + 1];
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                if(nums1[i] == nums2[j]) tabu[i][j] = 1 + tabu[i + 1][j+1];
                else{
                    int op1 = tabu[i + 1][j];
                    int op2 = tabu[i][j + 1];
                    tabu[i][j] = Math.max(op1,op2);
                }
            }
        }
        return tabu[0][0];
    }
}