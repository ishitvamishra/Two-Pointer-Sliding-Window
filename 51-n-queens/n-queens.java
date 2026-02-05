class Solution {
    public void solve(int col,char[][] board,int n, int[] lr, int[] ud, int[] ld, List<List<String>> res){
        if(n == col){
            List<String>temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int row = 0;row<n;row++){
            if(lr[row] == 0 && ld[row+col] == 0 && ud[n-1+col-row] ==0){
                board[row][col] =  'Q';
                lr[row] = 1;
                ld[row+col] = 1;
                ud[n-1+col-row] = 1;

                solve(col+1, board, n,lr,ud,ld,res);
                //backtrack
                board[row][col] = '.';
                lr[row] = 0;
                ld[row+col] = 0;
                ud[n-1+col-row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        int[] lr = new int[n];
        int[] ld = new int[2*n-1];
        int[] ud = new int[2*n-1];
        solve(0,board,n, lr, ud, ld, res);
        return res;
    }
}