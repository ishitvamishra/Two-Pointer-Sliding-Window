class Solution {
    public void sortColors(int[] nums) {
        int start = -1;
        int mid = 0;
        int end = nums.length;

        while(mid< end){
            if(nums[mid] == 0){
                int temp = nums[++start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                mid++;
            }
            else if(nums[mid] == 1){
                mid ++;
            }
            else if(nums[mid] ==2){
                int temp = nums[--end];
                nums[end] = nums[mid];
                nums[mid] = temp;
            }
        }
    }
}