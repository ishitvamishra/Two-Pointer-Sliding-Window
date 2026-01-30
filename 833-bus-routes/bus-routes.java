class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedBus = new boolean[routes.length];

        for (int bus : stopToBuses.getOrDefault(source, new ArrayList<>())) {
            q.add(bus);
            visitedBus[bus] = true;
        }

        int busesTaken = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int bus = q.poll();

                for (int stop : routes[bus]) {
                    if (stop == target) return busesTaken;

                    for (int nextBus : stopToBuses.get(stop)) {
                        if (!visitedBus[nextBus]) {
                            visitedBus[nextBus] = true;
                            q.add(nextBus);
                        }
                    }
                }
            }
            busesTaken++;
        }

        return -1;
    }
}
