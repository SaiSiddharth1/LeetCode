class Solution {
    String s,p;
    boolean[][] tabu;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        int n = s.length();
        int m = p.length();
        tabu = new boolean[n + 1][m + 1];
        tabu[0][0] = true;
        for(int j = 1 ; j <= m ; j++){
            if(p.charAt(j - 1) == '*'){
                tabu[0][j] =  tabu[0][j-1];
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    boolean anss = tabu[i-1][j-1];
                    tabu[i][j] = anss;
                    continue;
                }
                boolean op1 = false;
                boolean op2 = false;
                boolean op3 = false;
                if(p.charAt(j - 1) == '*'){
                    op1 = tabu[i][j-1];
                    op2 = tabu[i-1][j];
                }
                boolean ans = op1 || op2 || op3;
                tabu[i][j] = ans;
            }
        }
        return tabu[n][m];
    }
}