class Solution {
    String s,t;
    int[][] memo;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        int n = s.length();
        int m = t.length();
        memo = new int[n + 1][m + 1];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return solve(n,m);
    }
    int solve(int i,int j){
        if(j == 0) return 1;
        if(i == 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(s.charAt(i - 1) == t.charAt(j - 1)){
            return memo[i][j] = solve(i-1,j-1) + solve(i-1,j); 
        }
        return memo[i][j] = solve(i-1,j);
    }
}