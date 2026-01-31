class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for(int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new int[]{v, w});
        }

        // Step 2: Distance array
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Step 3: Min Heap (time, node)
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> a[0]-b[0]);

        pq.offer(new int[]{0, k});
        dist[k] = 0;

        // Step 4: Dijkstra
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            int time = cur[0];
            int node = cur[1];

            if(time > dist[node]) continue;

            for(int[] nei : graph.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if(dist[next] > time + wt) {
                    dist[next] = time + wt;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        // Step 5: find max
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}