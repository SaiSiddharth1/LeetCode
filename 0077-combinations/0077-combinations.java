class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(0,n,k,new ArrayList<>());
        return ans;
    }

    void backtrack(int idx,int n,int k,List<Integer> ls){
        if(ls.size() == k){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = idx ; i < n ; i++){
            ls.add(i+1);
            backtrack(i + 1,n,k,ls);
            ls.remove(ls.size() - 1);
        }
    }
}