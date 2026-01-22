class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            max = Math.max(nums[i], max);
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }



        int[] comp = new int[max+1];

        for(int i = 0;i<comp.length;i++){
            comp[i] = i*freq.getOrDefault(i,0);
        }

        int[] dp = new int[max+1];
        dp[0] = comp[0];
        dp[1] = Math.max(comp[0], comp[1]);
        for(int i = 2;i< dp.length;i++){
            dp[i] = Math.max(dp[i-1], comp[i]+dp[i-2]);
        }
        return dp[max];


    }
}