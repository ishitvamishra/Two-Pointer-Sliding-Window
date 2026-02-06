class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            boolean[] row = new boolean[n + 1];
            boolean[] col = new boolean[n + 1];

            for(int j = 0; j < n; j++){
                int r = matrix[i][j];
                int c = matrix[j][i];

                if(row[r]) return false;
                if(col[c]) return false;  // check kr rhey ki jo value mili h kya vo pehle vhi mil chuki ya nhi

                row[r] = true;
                col[c] = true; //visited mark kr rhey 
            }
        }
        return true;
    }
}
