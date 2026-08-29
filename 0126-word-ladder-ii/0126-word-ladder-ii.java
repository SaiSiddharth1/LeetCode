class Solution 
{
    Map<String,Integer> map;
    List<List<String>> ans;
    String beginWord;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
        map = new HashMap<>();
        ans = new ArrayList<>(); 
        this.beginWord = beginWord;

        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        set.remove(beginWord);
        map.put(beginWord,1);
        while(!q.isEmpty()){
            String curr = q.remove();
            int lvl = map.get(curr);
            if(curr.equals(endWord)) break;
            for(int i = 0 ; i < curr.length() ; i++){
                StringBuilder sb = new StringBuilder(curr);
                for(char c = 'a' ; c <= 'z' ; c++){
                    sb.setCharAt(i,c);
                    String s = sb.toString();
                    if(set.contains(s)){
                        q.add(s);
                        set.remove(s);
                        map.put(s,lvl + 1);
                    }
                }
            }
        }

        if(map.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }

        return ans;
    }




    private void dfs(String curr,List<String> seq)
    {

        if(curr.equals(beginWord)){
            List<String> seqq = new ArrayList(seq);
            Collections.reverse(seqq);
            ans.add(new ArrayList<>(seqq));
            return;
        }
        int steps = map.get(curr);
        for(int i = 0 ; i < curr.length() ; i++){
            StringBuilder sb = new StringBuilder(curr);
            for(char c = 'a' ; c <= 'z' ; c++){
                sb.setCharAt(i,c);
                String word = sb.toString();
                if(map.containsKey(word) && map.get(word) + 1 == steps){
                    seq.add(word);
                    dfs(word,seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }

    }

}