class Solution {
    public int strStr(String h, String ne) {
        int n = h.length();
        int m = ne.length();
        
        if (m == 0) return 0;
        
        int i = 0, j = 0;
        while (i < n) {
            if (h.charAt(i) == ne.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1; // Reset i to the next starting position
                j = 0;         // Reset needle pointer
            }
            
            if (j == m) {
                return i - m;  // Correct starting index
            }
        }
        return -1;
    }
}