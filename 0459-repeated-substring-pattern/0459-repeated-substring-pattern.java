class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int window = 1 ; window <= n/2 ; window++){
            if(n % window == 0 && s.substring(0,window).repeat(n/window).equals(s)){
                return true;
            }
        }
        return false;
    }
}