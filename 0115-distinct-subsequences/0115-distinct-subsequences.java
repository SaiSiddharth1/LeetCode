class Solution {
    String s,t;
    int[][] tabu;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        int n = s.length();
        int m = t.length();
        tabu = new int[n + 1][m + 1];
        for(int i = 0 ; i <= n ; i++){
            tabu[i][0] = 1;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    tabu[i][j] = tabu[i-1][j-1] + tabu[i-1][j]; 
                    continue;
                }
                tabu[i][j] = tabu[i-1][j];
            }
        }
        return tabu[n][m];
    }
}