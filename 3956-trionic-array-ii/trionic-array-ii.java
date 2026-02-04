class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;

        // Long.MIN_VALUE / 2 is used to prevent underflow when adding numbers
        long INF = Long.MAX_VALUE / 4;

        // dp[i][state] = max sum ending at index i in a specific state
        // state 0: Increasing (l...p)
        // state 1: Decreasing (p...q)
        // state 2: Increasing (q...r)
        long[][] dp = new long[n][3];
        
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = -INF;
        }

        long result = -INF;

        for (int i = 0; i < n; i++) {
            // State 0: Can start a new increasing sequence here OR extend one
            if (i > 0 && nums[i] > nums[i - 1]) {
                // To start: must at least have nums[i-1] and nums[i]
                // We pick either just the previous element or the best dp[i-1][0]
                long prevBase = Math.max((long)nums[i - 1], dp[i - 1][0]);
                dp[i][0] = prevBase + nums[i];
            }

            // State 1: Transition from State 0 (Peak reached) OR extend State 1
            if (i > 0 && nums[i] < nums[i - 1]) {
                long fromPrevState = dp[i - 1][0];
                long extendState = dp[i - 1][1];
                dp[i][1] = Math.max(fromPrevState, extendState) + nums[i];
            }

            // State 2: Transition from State 1 (Valley reached) OR extend State 2
            if (i > 0 && nums[i] > nums[i - 1]) {
                long fromPrevState = dp[i - 1][1];
                long extendState = dp[i - 1][2];
                dp[i][2] = Math.max(fromPrevState, extendState) + nums[i];
            }

            // The global maximum is found in the final trionic state
            result = Math.max(result, dp[i][2]);
        }

        return result;
    }
}