class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) return -1;

        Queue<ArrayList<Integer>> q = new LinkedList<>();

        ArrayList<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        q.add(start);

        grid[0][0] = 1;

        while (!q.isEmpty()) {
            ArrayList<Integer> curr = q.poll();
            int i = curr.get(0);
            int j = curr.get(1);

            if (i == n - 1 && j == m - 1) {
                return grid[i][j];
            }

            int dist = grid[i][j];

            // down
            if (i + 1 < n && grid[i + 1][j] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i + 1);
                pair.add(j);
                q.add(pair);
                grid[i + 1][j] = dist + 1;
            }

            // up
            if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i - 1);
                pair.add(j);
                q.add(pair);
                grid[i - 1][j] = dist + 1;
            }

            // right
            if (j + 1 < m && grid[i][j + 1] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j + 1);
                q.add(pair);
                grid[i][j + 1] = dist + 1;
            }

            // left
            if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j - 1);
                q.add(pair);
                grid[i][j - 1] = dist + 1;
            }

            // diagonals

            // up-left
            if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i - 1);
                pair.add(j - 1);
                q.add(pair);
                grid[i - 1][j - 1] = dist + 1;
            }

            // down-left
            if (i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i + 1);
                pair.add(j - 1);
                q.add(pair);
                grid[i + 1][j - 1] = dist + 1;
            }

            // up-right
            if (i - 1 >= 0 && j + 1 < m && grid[i - 1][j + 1] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i - 1);
                pair.add(j + 1);
                q.add(pair);
                grid[i - 1][j + 1] = dist + 1;
            }

            // down-right
            if (i + 1 < n && j + 1 < m && grid[i + 1][j + 1] == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i + 1);
                pair.add(j + 1);
                q.add(pair);
                grid[i + 1][j + 1] = dist + 1;
            }
        }

        return -1;
    }
}
