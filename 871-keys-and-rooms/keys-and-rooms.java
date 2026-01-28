class Solution {

    public void DFS(List<List<Integer>> rooms, int room, boolean[] visited) {
        // agar already visit ho chuka hai to return
        if (visited[room]) return;

        // mark visited
        visited[room] = true;

        // is room me jitni bhi keys hain, un rooms pe jao
        for (int key : rooms.get(room)) {
            DFS(rooms, key, visited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        // start from room 0
        DFS(rooms, 0, visited);

        // check if all rooms are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
