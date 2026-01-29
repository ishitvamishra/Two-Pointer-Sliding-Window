class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        // store: row, col, distance
        q.add(new int[]{entrance[0], entrance[1], 0});

        // mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        // 4 possible directions: down, up, right, left
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int dist = cur[2];

            for (int d = 0; d < 4; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];

                // check bounds and empty cell
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && maze[ni][nj] == '.') {

                    // if it's on boundary, it's an exit
                    if (ni == 0 || ni == n - 1 || nj == 0 || nj == m - 1) {
                        return dist + 1;
                    }

                    // mark visited and push to queue
                    maze[ni][nj] = '+';
                    q.add(new int[]{ni, nj, dist + 1});
                }
            }
        }

        return -1; // no exit found
    }
}
