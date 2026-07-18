class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> g = new HashMap<>();
		for(int i = 0 ; i < n ; i++){
		    g.put(i,new ArrayList<>());
		}
        for(int i = 0 ; i < edges.length ; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    g.get(u).add(v);
		    g.get(v).add(u);
		}
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(source);
        visited.add(source);
        while(!q.isEmpty()){
            int u = q.remove();
            if(u == destination) return true;
            for(int v : g.get(u)){
                if(!visited.contains(v)){
                    q.add(v);
                    visited.add(v);
                }
            }
        }
        return false;
    }
}