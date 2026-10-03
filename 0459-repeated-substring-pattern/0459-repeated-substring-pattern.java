class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int window = 1 ; window <= n/2 ; window++){
            if(n % window == 0){
                int i = window;
                while(i < n && s.charAt(i) == s.charAt(i % window)){
                    i++;
                }
                if(i == n){
                    return true;
                }
            }
        }
        return false;
    }
}