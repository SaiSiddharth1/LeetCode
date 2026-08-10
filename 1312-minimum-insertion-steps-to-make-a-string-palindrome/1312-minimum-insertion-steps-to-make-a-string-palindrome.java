class Solution {
    String s;
    int[] opti;
    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();
        opti = new int[n];
        for(int i = n - 2 ; i >= 0 ; i--){
            int[] temp = new int[n];
            for(int j = i + 1 ; j < n ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    temp[j] =  opti[j-1];
                    continue;
                }
                int op1 = temp[j-1];
                int op2 = opti[j];
                temp[j] = Math.min(op1,op2) + 1;
            }
            opti = temp;
        }
        
        return opti[n-1];
    }
}