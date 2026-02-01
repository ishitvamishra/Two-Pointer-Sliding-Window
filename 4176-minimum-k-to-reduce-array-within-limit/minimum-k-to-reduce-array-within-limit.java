class Solution {

    public int minimumK(int[] nums) {

        int low = 1;
        int high = 1;

        // Step 1: find upper bound (exponential increase)
        while (!canMake(nums, high)) {
            high *= 2;
        }

        int ans = high;

        // Step 2: binary search in [low, high]
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }


    private boolean canMake(int[] nums, int k) {
        long ops = 0;

        for (int x : nums) {
            ops += (x + k - 1) / k; // ceil(x/k)

            if (ops > (long) k * k) return false; // early stop
        }

        return ops <= (long) k * k;
    }
}
