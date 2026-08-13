class Solution {
    String s,p;
    int[][] memo;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        int n = s.length();
        int m = p.length();
        memo = new int[n + 1][m + 1];
        for(int[] arr : memo){
        Arrays.fill(arr,-1);
        }
        return solve(n,m);
    }

    boolean solve(int i,int j){
        if(i == 0 && j == 0) return true;
        if(j == 0 && i > 0) return false;
        if(i == 0 && j > 0){
            if(p.charAt(j - 1) == '*'){
                return solve(i,j-1);
            }
            return false;
        };

        if(memo[i][j] != -1){
            return (memo[i][j] == 1) ? true : false;
        }
        if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
            boolean anss = solve(i-1,j-1);
            memo[i][j] = (anss) ? 1 : 0;
            return  anss;
        }
        boolean op1 = false;
        boolean op2 = false;
        boolean op3 = false;
        if(p.charAt(j - 1) == '*'){
            op1 = solve(i,j-1);
            op2 = solve(i-1,j);
            op3 = solve(i-1,j - 1);
        }
        boolean ans = op1 || op2 || op3;
        memo[i][j] = (ans) ? 1 : 0;
        return ans;
    }
}