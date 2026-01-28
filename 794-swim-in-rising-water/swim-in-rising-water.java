class Solution {
    boolean dfs(int[][] grid, boolean[][] visited, int i , int j , int T){
        int n = grid.length;

        if(i<0 || j< 0|| i>=n|| j>=n|| visited[i][j] == true || grid[i][j] > T){
            return false;
        } 

        if(i == n-1 && j == n-1){
            return true;
        }

        visited[i][j] = true;
        return dfs(grid,visited,i+1,j,T) || dfs(grid,visited,i-1,j,T)|| dfs(grid,visited,i,j+1,T)||dfs(grid,visited,i,j-1,T);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = 0;
        int high = n*n;
        boolean visited[][] = new boolean[n][n];

        while(low<high){
            int mid = low+(high-low)/2;
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            if(dfs(grid, visited, 0, 0, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}


// 