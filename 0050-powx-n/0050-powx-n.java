class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long nn = n;
        if(nn < 0) nn =  -1 * nn;
        while(nn > 0){
            if(nn % 2 == 0){
                x = x * x;
                nn = nn / 2;
            }else {
                res = res *x;
                nn = nn - 1;
            }
        }
        if(n < 0) res = (double)1/(double)res;
        return res;
    }
}