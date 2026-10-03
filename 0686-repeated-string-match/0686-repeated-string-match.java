class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int n = a.length();
        int m = b.length();
        while(sb.length() < m){
            c++;
            sb.append(a);
        }
        if(sb.indexOf(b) != -1) return c;
        c++;
        sb.append(a);
        if(sb.indexOf(b) != -1) return c;
        return -1;
    }
}