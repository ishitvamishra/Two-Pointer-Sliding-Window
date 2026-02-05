class Solution {
    private int count =0; // locally bhi declare kr skte h par har recusion me carry krna padega

    public void solve(int col, int n, int[] lr, int[] ld, int[] ud){
        if(col == n){
            count++;
            return;
        }

        for(int row = 0; row < n; row++){
            if(lr[row] == 0 && ld[row+col] == 0 && ud[n-1+col-row] == 0){
                lr[row] = 1;
                ld[row+col] = 1;
                ud[n-1+col-row] = 1;

                solve(col+1,n,lr,ld,ud);

                lr[row] = 0;
                ld[row+col] = 0;
                ud[n-1+col-row] = 0;        
            }
        }
    }

    public int totalNQueens(int n) {
        int[] lr = new int[n];
        int[] ld = new int[2*n-1];
        int[] ud = new int[2*n-1];

        solve(0, n, lr, ld, ud);
        return count;
    }
}