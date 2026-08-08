class Solution {
    String s1;
    String s2;
    int[][] memo;
    public int minDistance(String word1, String word2) {
        this.s1 = word1;
        this.s2 = word2;
        int n = s1.length();
        int m = s2.length();
        memo = new int[n + 1][m + 1];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return (n  + m) - 2 * solve(n - 1,m - 1);
    }
    int solve(int i,int j){
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j]; 
        if(s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] = 1 + solve(i - 1,j - 1);
        }
        int op1 = solve(i - 1,j);
        int op2 = solve(i ,j - 1);
        return memo[i][j] = Math.max(op1,op2);
    }
}