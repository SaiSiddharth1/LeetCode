class Solution {
    public int smallestNumber(int n) {
        int ans = 1;
        while(n > 0){
            ans += ans;
            n >>= 1;
        }
        return ans - 1;
    }
}