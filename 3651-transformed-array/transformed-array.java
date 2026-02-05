class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int idx = ((i + nums[i]) % n + n) % n;
            arr[i] = nums[idx];
        }

        return arr;
    }
}
