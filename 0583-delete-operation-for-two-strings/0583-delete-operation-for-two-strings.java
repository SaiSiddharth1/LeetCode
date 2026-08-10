class Solution {
    String s1;
    String s2;
    int[] opti;
    public int minDistance(String word1, String word2) {
        this.s1 = word1;
        this.s2 = word2;
        int n = s1.length();
        int m = s2.length();
        opti = new int[m + 1];
        for(int i = 1 ; i <= n ; i++){
            int[] temp = new int[m + 1];
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    temp[j] = 1 + opti[j - 1];
                    continue;
                }
                int op1 = opti[j];
                int op2 = temp[j - 1];
                temp[j] = Math.max(op1,op2);
            }
            opti = temp;
        }
        return (n  + m) - 2 * opti[m];
    }
}