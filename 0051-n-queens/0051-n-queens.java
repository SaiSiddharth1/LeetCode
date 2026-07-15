class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] ls = new char[n][n];
        for(int i =0 ; i < n ; i++){
            Arrays.fill(ls[i],'.');
        }
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2 * n - 1];
        int[] lowerDiag = new int[2 * n - 1];
        backtrack(0,ls,res,n,leftRow,upperDiag,lowerDiag);
        return res;
    }

    void backtrack(int col,char[][] ls,List<List<String>> res,int n,int[] leftRow,int[] upperDiag,int[] lowerDiag){
        if(col == n){
            List<String> temp =new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                temp.add(new String(ls[i]));
            }
            res.add(temp);
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(leftRow[i] == 0 && upperDiag[n - 1 + col - i] == 0 && lowerDiag[i + col] ==0){
                leftRow[i] = 1;
                upperDiag[n - 1 + col - i] = 1;
                lowerDiag[i + col] = 1;
                ls[i][col] = 'Q';
                backtrack(col + 1,ls,res,n,leftRow,upperDiag,lowerDiag);
                ls[i][col] = '.';
                leftRow[i] = 0;
                upperDiag[n - 1 + col - i] = 0;
                lowerDiag[i + col] = 0;
            }
        }
    }
}