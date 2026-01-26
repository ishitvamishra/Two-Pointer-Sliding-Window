class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;

        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFormPairs(nums, p, mid)) {
                ans = mid;
                high = mid - 1;   // try smaller maximum difference
            } else {
                low = mid + 1;    // need larger difference
            }
        }

        return ans;
    }

    // Greedy check: can we make at least p pairs with diff <= maxDiff?
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2; // use both indices
            } else {
                i++;    // skip current index
            }

            if (count >= p) return true;
        }

        return false;
    }
}
