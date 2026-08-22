class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int max = (int)2e4 + 1;
        SegmentTree s = new SegmentTree(max);
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int x = nums[i];
            x += (int) 1e4;
            ans.add(s.rangeQuery(0,x-1));
            s.update(x);
        }
        Collections.reverse(ans);
        return ans;
    }
}

class SegmentTree{
    private int[] st;
    int n;
    SegmentTree(int n){
        this.n = n;
        st = new int[4 * n]; 
        rangeQuery(0,n-1);
    }

    int rangeQuery(int l,int r){
        return rangeHelper(0,0,n,l,r);
    }

    int rangeHelper(int idx,int ss,int se,int qs,int qe){
        if(qe < ss || qs > se) return 0;
        if(qs <= ss && se <= qe) {
            return st[idx];
        }
        int mid = (ss + se)/2; 
        int l = rangeHelper(2 * idx + 1,ss,mid,qs,qe); 
        int r = rangeHelper(2 * idx + 2,mid + 1 , se,qs,qe); 
        return l + r;
    }
    void update(int idx){
        int treeIdx = 0;
        int ss = 0,se = n;
        while(ss != se){
            int mid = (ss + se) >> 1;
            if(idx > mid){
                treeIdx = 2 * treeIdx + 2;
                ss = mid + 1;
            }else{
                treeIdx = 2 * treeIdx + 1;
                se = mid;
            }
        }
        while(treeIdx > 0){
            st[treeIdx]++;
            treeIdx = (treeIdx - 1)/2;
        }
    }
    
}