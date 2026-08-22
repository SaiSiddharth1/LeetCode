class Solution {
    private int MOD = (int) 1e9 + 7;
    public int createSortedArray(int[] instructions) {
        int max = Arrays.stream(instructions).max().getAsInt();
        SegmentTree s =  new SegmentTree(max);
        long cost = 0;
        for(int i : instructions){
            cost = ((cost) % MOD + Math.min(s.rangeQuery(0,i-1),s.rangeQuery(i + 1,max)) % MOD ) % MOD;
            s.update(i);
        }
        return (int) cost;
    }
}

class SegmentTree{
    private long[] st;
    int n;
    SegmentTree(int n){
        this.n = n;
        st = new long[4 * n]; 
        rangeQuery(0,n-1);
    }

    long rangeQuery(int l,int r){
        return rangeHelper(0,0,n,l,r);
    }

    long rangeHelper(int idx,int ss,int se,int qs,int qe){
        if(qe < ss || qs > se) return 0;
        if(qs <= ss && se <= qe) {
            return st[idx];
        }
        int mid = (ss + se)/2; 
        long l = rangeHelper(2 * idx + 1,ss,mid,qs,qe); 
        long r = rangeHelper(2 * idx + 2,mid + 1 , se,qs,qe); 
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