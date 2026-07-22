class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int l = 0 , r = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int c = 0;
        while(l < g.length && r < s.length){
            if(g[l] <= s[r]){
                l++;
                r++;
                c++;
            }else r++;
        }
        return c;
    }
}