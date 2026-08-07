class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for(int i : nums){
            s.add(i);
        }
        int x = 0;
        int[] nums2 = new int[s.size()];
        for(int i : s){
            nums2[x++] = i; 
        }
        memo = new int[nums.length][nums2.length];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return lcs(0,0,nums,nums2);
    }

    int lcs(int i,int j,int[] nums1,int[] nums2){
        if(i >= nums1.length || j >= nums2.length) return 0;
        if(nums1[i] == nums2[j]) return 1 + lcs(i + 1,j+1,nums1,nums2);
        if(memo[i][j] != -1) return memo[i][j];
        int op1 = lcs(i + 1,j,nums1,nums2);
        int op2 = lcs(i,j + 1,nums1,nums2);
        return memo[i][j] = Math.max(op1,op2);
    }
}