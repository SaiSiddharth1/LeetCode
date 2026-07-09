class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            Set<Long> s = new HashSet<>();
            for(int j = i + 1 ; j < n ; j++){
                long third = (long) -(nums[i] + nums[j]);
                if(s.contains(third)){
                    List<Integer> ls = Arrays.asList(nums[i],nums[j],(int) third);
                    Collections.sort(ls);
                    set.add(ls);
                }
                s.add((long) nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList(set);
        return ans;
    }
}