class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        int fresh = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ArrayList<Integer> pair = new ArrayList<>();
                if(grid[i][j] == 2){
                    pair.add(i);
                    pair.add(j);
                    q.add(pair);
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int time = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            time++;
            for(int k = 0;k< size;k++){
                ArrayList<Integer> curr =new ArrayList<>();
                curr = q.remove();
                int i = curr.get(0);
                int j = curr.get(1);

                if(i+1 < n && grid[i+1][j] ==  1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i+1);
                    pair.add(j);
                    q.add(pair);
                    grid[i+1][j] = 2;
                    fresh--;
                }

                if(i-1 >= 0 && grid[i-1][j] ==  1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i-1);
                    pair.add(j);
                    q.add(pair);
                    grid[i-1][j] = 2;
                    fresh--;
                }

                if(j+1 < m && grid[i][j+1] ==  1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j+1);
                    q.add(pair);
                    grid[i][j+1] = 2;
                    fresh--;
                }

                if(j-1 >= 0 && grid[i][j-1] ==  1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j-1);
                    q.add(pair);
                    grid[i][j-1] = 2;
                    fresh--;
                }
            }
        }

        if(fresh > 0) return -1;   //agar last me ek bhi fresh bach gya toh -1 return hoga
        return time;
    }
}
