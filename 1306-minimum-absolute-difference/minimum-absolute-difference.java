class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        for(int i = 0;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i]) == minDiff){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                result.add(pair);
            }
        }
        return result;
    }
}