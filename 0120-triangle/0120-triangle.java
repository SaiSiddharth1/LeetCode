class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        List<Integer> front = new ArrayList<>(); 
        for(int j = 0 ; j < col ; j++){
            front.add(triangle.get(row - 1).get(j));
        }
        for(int i = row - 2 ; i >= 0 ; i--){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0 ; j <= i ; j++){
                int d = front.get(j);
                int dr = front.get(j + 1);
               curr.add(triangle.get(i).get(j) +  Math.min(d,dr));
            }
            front = curr;
        }
        return front.get(0);
    }
}