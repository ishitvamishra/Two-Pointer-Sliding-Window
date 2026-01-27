class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // Step 1: Sort
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];   // height descending
            return a[0] - b[0];       // width ascending
        });

        // Step 2: LIS on heights
        int n = envelopes.length;
        int[] temp = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int h = envelopes[i][1];

            int low = 0, high = len - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (temp[mid] < h)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            temp[low] = h;
            if (low == len) len++;
        }

        return len;
    }
}