class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                
                if(board[i][j] == '.'){
                    
                    for(char c = '1'; c <= '9'; c++){
                        
                        if(isSafe(board, i, j, c)){
                            board[i][j] = c;
                            
                            if(solve(board))
                                return true;
                            
                            board[i][j] = '.'; // backtrack
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, char num){
        
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num) return false;
            if(board[i][col] == num) return false;
            
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            if(board[r][c] == num) return false;
        }
        
        return true;
    }
}