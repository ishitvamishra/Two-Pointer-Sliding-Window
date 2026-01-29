class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        int other = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ArrayList<Integer> pair = new ArrayList<>();
                if(grid[i][j] == 0){
                    pair.add(i);
                    pair.add(j);
                    q.add(pair);
                }
                else{
                    grid[i][j] = -1;
                    other++;
                }
            }
        }



        while(!q.isEmpty() && other > 0){
            int size = q.size();

            for(int k = 0;k< size;k++){
                ArrayList<Integer> curr =new ArrayList<>();
                curr = q.remove();
                int i = curr.get(0);
                int j = curr.get(1);

                if(i+1 < n && grid[i+1][j] ==  -1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i+1);
                    pair.add(j);
                    q.add(pair);
                    grid[i+1][j] = grid[i][j]+1;
                    other--;
                }

                if(i-1 >= 0 && grid[i-1][j] ==  -1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i-1);
                    pair.add(j);
                    q.add(pair);
                    grid[i-1][j] = grid[i][j]+1;
                    other--;
                }

                if(j+1 < m && grid[i][j+1] ==  -1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j+1);
                    q.add(pair);
                    grid[i][j+1] = grid[i][j]+1;
                    other--;
                }

                if(j-1 >= 0 && grid[i][j-1] ==  -1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j-1);
                    q.add(pair);
                    grid[i][j-1] = grid[i][j]+1;
                    other--;
                }
            }
        }

        return grid;
    }
}