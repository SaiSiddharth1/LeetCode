class Solution {
    String s,p;
    boolean[] opti;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        int n = s.length();
        int m = p.length();
        opti = new boolean[m + 1];
        opti[0] = true;
        for(int j = 1 ; j <= m ; j++){
            if(p.charAt(j - 1) == '*'){
                opti[j] =  opti[j-1];
            }
        }
        for(int i = 1 ; i <= n ; i++){
            boolean[] temp = new boolean[m + 1];
            for(int j = 1 ; j <= m ; j++){
                if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    boolean anss = opti[j-1];
                    temp[j] = anss;
                    continue;
                }
                boolean op1 = false;
                boolean op2 = false;
                boolean op3 = false;
                if(p.charAt(j - 1) == '*'){
                    op1 = temp[j-1];
                    op2 = opti[j];
                    op3 = opti[j - 1];
                }
                boolean ans = op1 || op2 || op3;
                temp[j] = ans;
            }
            opti = temp;
        }
        return opti[m];
    }
}