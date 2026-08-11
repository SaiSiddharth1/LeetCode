class Solution {
    String s1;
    String s2;
    int[][] tabu;
    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        int n = s1.length();
        int m = s2.length();
        tabu = new int[n + 1][m + 1];
        for(int i = 0 ; i <= n ; i++){
            tabu[i][0] = i;
        }
        for(int j = 0 ; j <= m ; j++){
            tabu[0][j] = j;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    tabu[i][j] = tabu[i-1][j-1];
                    continue;
                }
                int op1 = tabu[i][j-1];
                int op2 = tabu[i-1][j];
                int op3 = tabu[i-1][j-1];
                tabu[i][j] = 1 + Math.min(op3,Math.min(op1,op2));
            }
        }
        return tabu[n][m];
    }
}