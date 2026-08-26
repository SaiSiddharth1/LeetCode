class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);;
        if(!words.contains(endWord)) return 0;
        Map<String,Boolean> visited = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.put(beginWord,true);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            while(size-- > 0){
                String currWord = q.remove();
                if(currWord.equals(endWord)) return level;
                for(int i = 0 ; i < currWord.length() ; i++){
                    StringBuilder sb = new StringBuilder(currWord);
                    for(int j = 0 ; j < 26 ; j++){
                        char c =  (char) ('a' + j);
                        sb.setCharAt(i,c);
                        String s = sb.toString();
                        if(words.contains(s) && !visited.containsKey(s)){
                            visited.put(s,true);
                            q.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}