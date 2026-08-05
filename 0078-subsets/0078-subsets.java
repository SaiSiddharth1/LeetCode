class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        solve(0,nums,ls);
        return ans;
    }
    void solve(int idx,int[] nums,List<Integer> ls){
        ans.add(new ArrayList<>(ls));
        for(int i = idx ; i < nums.length ; i++){
            ls.add(nums[i]);
            solve(i + 1,nums,ls);
            ls.remove(ls.size() - 1);
        }
    }
}