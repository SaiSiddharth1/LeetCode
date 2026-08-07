class Solution {
    String s1;
    String s2;
    int[][] tabu;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        int n = s1.length();
        int m = s2.length();
        tabu = new int[n + 1][m + 1];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                if(s1.charAt(i) == s2.charAt(j)) {
                    tabu[i][j] = 1 + tabu[i + 1][j+ 1];
                    continue;
                }
                int op1 = tabu[i+1][j];
                int op2 = tabu[i][j + 1];
                tabu[i][j] = Math.max(op1,op2);
            }
        }
        return tabu[0][0];
    }
}