class Solution {
    String s1;
    String s2;
    int[][] tabu;
    public int minDistance(String word1, String word2) {
        this.s1 = word1;
        this.s2 = word2;
        int n = s1.length();
        int m = s2.length();
        tabu = new int[n + 1][m + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    tabu[i][j] = 1 + tabu[i - 1][j - 1];
                    continue;
                }
                int op1 = tabu[i - 1][j];
                int op2 = tabu[i][j - 1];
                tabu[i][j] = Math.max(op1,op2);
            }
        }
        return (n  + m) - 2 * tabu[n][m];
    }
}