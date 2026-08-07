class Solution {
    String s1;
    String s2;
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        memo = new int[s1.length()][s2.length()];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return LCS(0,0);
    }

    int LCS(int i,int j){
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(s1.charAt(i) == s2.charAt(j)) return 1 + LCS(i + 1 , j+ 1);
        if(memo[i][j] != -1) return memo[i][j];
        int op1 = LCS(i+1,j);
        int op2 = LCS(i,j + 1);
        return memo[i][j] = Math.max(op1,op2);
    }
}