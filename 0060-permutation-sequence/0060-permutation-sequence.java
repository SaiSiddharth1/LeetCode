class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i = 1 ; i <= n ; i++){
            arr[i - 1] = i;
        }
        boolean[] used = new boolean[n];
        backtrack(0,arr,used);
        StringBuilder sb = new StringBuilder();
        for(int i  : res.get(k - 1)){
            sb.append(i);
        }
        return sb.toString();
    }
    void backtrack(int idx,int[] arr,boolean[] used){
        if(temp.size() == arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(!used[i]){
                used[i] = true;
                temp.add(arr[i]);
                backtrack(i,arr,used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
    void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}