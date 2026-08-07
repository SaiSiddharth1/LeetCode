class Solution {
    String s1;
    String s2;
    int[] opti;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        int n = s1.length();
        int m = s2.length();
        opti = new int[m + 1];

        for(int i = n - 1 ; i >= 0 ; i--){
            int[] temp = new int[m + 1];
            for(int j = m - 1 ; j >= 0 ; j--){
                if(s1.charAt(i) == s2.charAt(j)) {
                    temp[j] = 1 + opti[j + 1];
                    continue;
                }
                int op1 = opti[j];
                int op2 = temp[j + 1];
                temp[j] = Math.max(op1,op2);
            }
            opti = temp;
        }
        return opti[0];
    }
}