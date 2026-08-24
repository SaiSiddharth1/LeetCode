class Solution {
    int[] inDegree;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        inDegree = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int x : graph[i]){
                adj.get(x).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safe = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            for(int x : adj.get(node)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    q.add(x);  
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0){
                safe.add(i);
            }
        }
        return safe;
    }
}