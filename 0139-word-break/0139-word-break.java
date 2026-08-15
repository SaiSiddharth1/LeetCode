class Solution {
    String s;
    boolean[] tabu;
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        int n = s.length();
        tabu = new boolean[n + 1];
        set = new HashSet<>();
        for(String ss : wordDict){
            set.add(ss);
        }
        for(int idx = 0 ; idx < n ; idx++){
            for(int start = 0 ; start <= idx ; start++){
            String word = s.substring(start,idx + 1);
                if(set.contains(word)){
                    if(start == 0 || tabu[start - 1]){
                        tabu[idx] = true;
                        break;
                    }
                }
            }   
        }
        return tabu[n - 1];
    }
}