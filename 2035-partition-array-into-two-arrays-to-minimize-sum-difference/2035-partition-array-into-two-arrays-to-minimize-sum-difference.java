class Solution {
    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N/2,res = Integer.MAX_VALUE;
        int sum = Arrays.stream(nums).sum();
        List<List<Integer>> left = new ArrayList<>(n+1);
        List<List<Integer>> right = new ArrayList<>(n+1);
        for(int i = 0 ; i <= n ; i++){
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        for(int mask = 0 ; mask < (1 << n) ; mask++){
            int sz = 0 , l = 0 , r = 0;
            for(int bit = 0 ; bit < n ; bit++){
                if((mask & (1 << bit)) != 0){
                    sz++;
                    l += nums[bit];
                    r += nums[bit + n];
                }
            }
            left.get(sz).add(l);
            right.get(sz).add(r);
        }

        for(int i = 0 ; i <= n ; i++){
            Collections.sort(right.get(i));
        }
        res = Math.min(res,Math.abs(sum - (2 * right.get(n).get(0))));
        res = Math.min(res,Math.abs(sum - (2 * left.get(n).get(0))));
        for(int sz = 1 ; sz < n ; sz++){
            for(int a : left.get(sz)){
                int b = (sum - (2 * a))/2;
                int rsz = n - sz;
                List<Integer> ls = right.get(rsz);
                int itr = lowerBound(ls,b);

                if(itr != ls.size()){
                    res = Math.min(res,Math.abs(sum - 2 * (a + ls.get(itr))));
                }
                if(itr != 0){
                    int it = itr;
                    it--;
                    res = Math.min(res,Math.abs(sum - 2 * (a + ls.get(it))));
                }
            }
        }
        return res;
    }

    int lowerBound(List<Integer> ls,int x){
        int l = 0;
        int r = ls.size();
        while( l < r ){
            int mid = l + (r - l)/2;
            if(ls.get(mid) < x){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}