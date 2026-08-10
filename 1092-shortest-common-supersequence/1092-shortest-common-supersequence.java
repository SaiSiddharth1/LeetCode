class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] tabu = new int[n + 1][m + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    tabu[i][j] = 1 + tabu[i-1][j-1];
                    continue;
                }
                int op1 = tabu[i-1][j];
                int op2 = tabu[i][j-1];
                tabu[i][j] = Math.max(op1,op2);
            }
        }
        StringBuilder ans = new StringBuilder();
        int l = n, r = m;
        while(l > 0 && r > 0){
            if(s1.charAt(l-1) == s2.charAt(r-1)){
                ans.append(s1.charAt(l-1));
                l--;
                r--;
            }
            else if(tabu[l-1][r] > tabu[l][r-1]){
                ans.append(s1.charAt(l-1));
                l--;
            }else{
                ans.append(s2.charAt(r-1));
                r--;
            }
        }
        while(l > 0){
            ans.append(s1.charAt(l-1));
            l--;
        }
        while(r > 0){
            ans.append(s2.charAt(r-1));
            r--;
        }
        return ans.reverse().toString();
    }
}