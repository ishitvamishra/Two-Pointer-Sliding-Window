class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // Pair bana lenge (difficulty, profit) ke liye
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort workers by ability
        Arrays.sort(worker);

        int totalProfit = 0;
        int bestProfitSoFar = 0;
        int jobIndex = 0;

        // Traverse workers from weakest to strongest
        for (int w : worker) {
            // Add all jobs that this worker can do
            while (jobIndex < n && jobs[jobIndex][0] <= w) {
                bestProfitSoFar = Math.max(bestProfitSoFar, jobs[jobIndex][1]);
                jobIndex++;
            }
            // Assign this worker the best available job
            totalProfit += bestProfitSoFar;
        }

        return totalProfit;
    }
}
