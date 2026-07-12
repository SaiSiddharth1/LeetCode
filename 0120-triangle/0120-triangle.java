class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] tabu = new int[row][col];
        for(int j = 0 ; j < col ; j++){
            tabu[row - 1][j] = triangle.get(row - 1).get(j);
        }
        for(int i = row - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                int d = tabu[i + 1][j];
                int dr = tabu[i + 1][j + 1];
               tabu[i][j] = triangle.get(i).get(j) +  Math.min(d,dr);
            }
        }
        return tabu[0][0];
    }
}