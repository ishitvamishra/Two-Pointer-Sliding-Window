class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p =0, q= 0, count =0;
        for(int i = 0;i<n-1; i++){
            if(nums[i] >= nums[i+1]){
                p = i;
                break;
            }
        }
        for(int i = p;i<n-1; i++){
            if(nums[i] <= nums[i+1]){
                q = i;
                break;
            }
        }
        for(int i = q;i<n-1; i++){
            if(nums[i] >= nums[i+1]){
                count++;
            }
        }

        if(p>0 && q>0 && count ==0){
            return true;
        }
        else{
            return false;
        }

    }
}