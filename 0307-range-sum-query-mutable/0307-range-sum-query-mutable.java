class NumArray {
    private int[] a;
    private int[] st;
    private int n;
    public NumArray(int[] arr) {
        n = arr.length;
        a = new int[n];
        st = new int[4*n];
        for(int i = 0 ; i < n ; i++){
            a[i] = arr[i];
        }
        buildSt(0,0,n-1);
    }
    public void buildSt(int idx,int ss,int se){
        if(ss == se) {
            st[idx] = a[ss];    
            return;
        }
        if(ss > se) return;
        int mid = (ss + se)/2;
        buildSt(2 * idx + 1,ss,mid);
        buildSt(2 * idx + 2,mid + 1,se);
        st[idx] = st[2 * idx + 1] + st[2 * idx + 2];
    }
    public void update(int idx, int val) {
        int xVal = val - a[idx];
        a[idx] += xVal;
        int ss = 0;
        int se = n - 1;
        int treeIdx = 0;
        while(ss != se){
            int mid = (ss + se)/2;
            if(idx > mid){
                treeIdx = 2 * treeIdx + 2;
                ss = mid + 1;
            }else{
                treeIdx = 2 * treeIdx + 1;
                se = mid;
            }
        }
        st[treeIdx] += xVal;
        while(treeIdx > 0){
            treeIdx = (treeIdx - 1)/2;
            st[treeIdx] += xVal; 
        } 
    }
    
    public int sumRange(int left, int right) {
        return rangeSum(0,0,n-1,left,right);
    }

    public int rangeSum(int idx,int ss,int se,int qs,int qe){
        if(ss > qe || qs> se) return 0;
        if(qs <= ss && se <= qe) return st[idx];
        int mid = (ss + se)>>1;
        int l = rangeSum(2 * idx + 1,ss,mid,qs,qe);
        int r = rangeSum(2 * idx + 2,mid+1,se,qs,qe);
        return l + r;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */