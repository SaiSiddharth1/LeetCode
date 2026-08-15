class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0];
        });
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        int ans = 0;
        for(int[] it : intervals){
            if(end > it[0]){
                end = Math.min(end,it[1]);
                ans++;
            }else{
                start = it[0];
                end = it[1];
            }
        }
        return ans;
    }
}