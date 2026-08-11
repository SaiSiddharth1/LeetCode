class Solution {
    String s1;
    String s2;
    int[] opti;
    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        int n = s1.length();
        int m = s2.length();
        opti = new int[m + 1];
        for(int i = 0 ; i <= m ; i++){
            opti[i] = i;
        }

        for(int i = 1 ; i <= n ; i++){
            int[] temp = new int[m + 1];
            temp[0] = i;
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    temp[j] = opti[j-1];
                    continue;
                }
                int op1 = temp[j-1];
                int op2 = opti[j];
                int op3 = opti[j-1];
                temp[j] = 1 + Math.min(op3,Math.min(op1,op2));
            }
            opti = temp;
        }
        return opti[m];
    }
}