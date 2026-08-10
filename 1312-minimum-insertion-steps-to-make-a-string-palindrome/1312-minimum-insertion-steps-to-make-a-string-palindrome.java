class Solution {
    String s;
    int[][] memo;
    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();
        memo = new int[n][n];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        return solve(0,n-1);
    }
    int solve(int i,int j){
        if(i >= j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return solve(i+1,j-1);
        }
        int op1 = solve(i,j-1);
        int op2 = solve(i + 1,j);
        return memo[i][j] = Math.min(op1,op2) + 1;
    }
}