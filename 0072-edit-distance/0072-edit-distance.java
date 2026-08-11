class Solution {
    String s1;
    String s2;
    int[][] memo;
    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        int n = s1.length();
        int m = s2.length();
        memo = new int[n + 1][m + 1];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return solve(n,m);
    }
    int solve(int i,int j){
        if(i == 0) return j;
        if(j == 0) return i;
        if(memo[i][j] != -1) return memo[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return memo[i][j] = solve(i-1,j-1);
        }
        int op1 = solve(i,j-1);
        int op2 = solve(i-1,j);
        int op3 = solve(i-1,j-1);
        return  memo[i][j] = 1 + Math.min(op3,Math.min(op1,op2));
    }
}