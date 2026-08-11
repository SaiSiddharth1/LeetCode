class Solution {
    String s,t;
    int[] opti;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        int n = s.length();
        int m = t.length();
        opti = new int[m + 1];
        opti[0] = 1;
        for(int i = 1 ; i <= n ; i++){
            int[] temp = new int[m + 1];
            temp[0] = 1;
            for(int j = 1 ; j <= m ; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    temp[j] = opti[j-1] + opti[j]; 
                    continue;
                }
                temp[j] = opti[j];
            }
            opti = temp;
        }
        return opti[m];
    }
}