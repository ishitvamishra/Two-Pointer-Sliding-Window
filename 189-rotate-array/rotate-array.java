class Solution {
    public void rotate(int[] nums, int d) {
        int n= nums.length;
        d= (d%n + n)%n;
        rev(nums, 0, n-1);
        rev(nums, 0, d-1);
        rev(nums, d, n-1);

    }

    static void rev(int arr[], int start, int end) {
        while(start<end) {
            int temp= arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        } 
    }
}