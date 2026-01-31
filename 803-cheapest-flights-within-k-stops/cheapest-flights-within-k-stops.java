class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        // distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        int stops = 0;

        // BFS by levels (stops)
        while(!q.isEmpty() && stops <= k) {

            int size = q.size();

            int[] temp = Arrays.copyOf(dist, n);

            while(size-- > 0) {
                int[] cur = q.poll();
                int node = cur[0];
                int cost = cur[1];

                for(int[] nei : graph.get(node)) {
                    int next = nei[0];
                    int price = nei[1];

                    if(cost + price < temp[next]) {
                        temp[next] = cost + price;
                        q.offer(new int[]{next, temp[next]});
                    }
                }
            }

            dist = temp;
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}