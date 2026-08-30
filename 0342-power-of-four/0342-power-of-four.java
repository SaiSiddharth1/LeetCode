class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if((n & 1) == 1) return false;
        return solve(n);
    }
    boolean solve(int n){
        if(n == 1) return true;
        if(n <= 0 || (n < 4) ||(n & 1) == 1 || (n % 4) != 0) return false;
        return solve(n/4);
    }
}