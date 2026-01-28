class Solution {
    public void DFS(int[][] grid, int i, int j, int row, int col, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != oldColor) {
            return;
        }

        grid[i][j] = newColor;

        DFS(grid, i + 1, j, row, col,oldColor,newColor);
        DFS(grid, i - 1, j, row, col, oldColor,newColor);
        DFS(grid, i, j + 1, row, col,oldColor,newColor);
        DFS(grid, i, j - 1, row, col,oldColor,newColor);

    }

    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int n = grid.length;
        int m = grid[0].length;
        int oldColor = grid[sr][sc];
        if(oldColor == newColor) return grid;

        DFS(grid, sr, sc, n, m ,oldColor, newColor);

        return grid;
    }
}