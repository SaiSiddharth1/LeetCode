class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        int m3 = Integer.MAX_VALUE;
       for(int i = 0 ; i < n ; i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else max3 = Math.max(max3,nums[i]);
            
            if(nums[i] < m1){
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            }else if(nums[i] < m2){
                m3 = m2;
                m2 = nums[i];
            }else m3 = Math.min(m3,nums[i]);
       }
       int maxp = Math.max(max1*max2*max3,m1*m2*max1);
       return maxp;
    }
}