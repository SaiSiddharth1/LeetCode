class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums.length - 1,target,nums);
    }
    int solve(int idx,int t,int[] arr){
        if(idx < 0){
            return (t == 0) ? 1 : 0;    
        }
        String key = idx + "," + t;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int m = solve(idx-1,t + arr[idx],arr);
        int p = solve(idx-1,t - arr[idx],arr);
        map.put(key,p+m);
        return  p + m;
    }
}