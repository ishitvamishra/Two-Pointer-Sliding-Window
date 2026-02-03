class Solution {
    public void subset(int index, int[] nums, List<List<Integer>> ans , List<Integer>ds){
        if(index >= nums.length){
            ans.add(new ArrayList(ds));
            return;
        }

        ds.add(nums[index]);
        subset(index+1, nums,ans,ds);
        ds.remove(ds.size()-1);
        subset(index+1,nums,ans,ds);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(0,nums, ans, new ArrayList<>());
        return ans;
    }
}