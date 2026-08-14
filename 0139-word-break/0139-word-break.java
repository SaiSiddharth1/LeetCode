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
        return solve(0);
    }

    boolean solve(int idx){
        if(idx == s.length()) return true;
        if(memo[idx] != null) return memo[idx];
        for(int end = idx + 1 ; end <= s.length() ; end++){
            String word = s.substring(idx,end);
            if(set.contains(word)){
                if(solve(end)){
                    return memo[idx] = true;
                }
            }
        }
        return memo[idx] = false;
    }
}