class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0){
                arr[i] = nums[(nums[i]+i)%n];
            }
            else if(nums[i] < 0){
                arr[i] = nums[(n+(i-Math.abs(nums[i]))%n)%n];
            }
            else{
                arr[i] = nums[i];
            }
        }
        return arr;
    }
}