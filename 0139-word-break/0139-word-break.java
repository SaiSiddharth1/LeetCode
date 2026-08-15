class Solution {
    String s;
    Set<String> set;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        memo = new Boolean[s.length()];
        set = new HashSet<>();
        for(String ss : wordDict){
            set.add(ss);
        }
        return solve(s.length() - 1);
    }

    boolean solve(int idx){
        if(idx < 0) return true;
        if(memo[idx] != null) return memo[idx];
        for(int start = 0 ; start <= idx ; start++){
            String word = s.substring(start,idx + 1);
            if(set.contains(word)){
                if(solve(start - 1)){
                    return memo[idx] = true;
                }
            }
        }
        return memo[idx] = false;
    }
}