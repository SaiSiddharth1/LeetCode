class Solution {
    String s;
    int[][] tabu;
    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();
        tabu = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            tabu[i][i] = 0;
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = i + 1 ; j < n ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    tabu[i][j] =  tabu[i+1][j-1];
                    continue;
                }
                int op1 = tabu[i][j-1];
                int op2 = tabu[i + 1][j];
                tabu[i][j] = Math.min(op1,op2) + 1;
            }
        }
        
        return tabu[0][n-1];
    }
}