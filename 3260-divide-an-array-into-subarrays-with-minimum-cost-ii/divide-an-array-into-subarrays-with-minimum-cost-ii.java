class Solution {
    private TreeMap<Integer, Integer> small = new TreeMap<>();
    private TreeMap<Integer, Integer> large = new TreeMap<>();
    private int smallCount = 0;
    private long currentSmallSum = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int m = k - 1; // We need to pick m more subarray starts
        
        // Initial window starts from index 1 (nums[0] is fixed)
        // The window size is dist + 1
        for (int i = 1; i <= Math.min(dist + 1, n - 1); i++) {
            add(nums[i], m);
        }

        long minCost = nums[0] + currentSmallSum;

        // Slide the window: i is the new element entering, 
        // i - dist - 1 is the element leaving the window range
        for (int i = dist + 2; i < n; i++) {
            remove(nums[i - dist - 1], m);
            add(nums[i], m);
            minCost = Math.min(minCost, nums[0] + currentSmallSum);
        }

        return minCost;
    }

    private void add(int val, int m) {
        small.put(val, small.getOrDefault(val, 0) + 1);
        currentSmallSum += val;
        smallCount++;

        // If we have more than m elements, move the largest from 'small' to 'large'
        if (smallCount > m) {
            int maxVal = small.lastKey();
            removeFromMap(small, maxVal);
            currentSmallSum -= maxVal;
            smallCount--;
            large.put(maxVal, large.getOrDefault(maxVal, 0) + 1);
        }
    }

    private void remove(int val, int m) {
        if (small.containsKey(val)) {
            removeFromMap(small, val);
            currentSmallSum -= val;
            smallCount--;
        } else {
            removeFromMap(large, val);
        }

        // If 'small' is now under-filled, pull the smallest from 'large'
        if (smallCount < m && !large.isEmpty()) {
            int minVal = large.firstKey();
            removeFromMap(large, minVal);
            small.put(minVal, small.getOrDefault(minVal, 0) + 1);
            currentSmallSum += minVal;
            smallCount++;
        }
    }

    private void removeFromMap(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
}