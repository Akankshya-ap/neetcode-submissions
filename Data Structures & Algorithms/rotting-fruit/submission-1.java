class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;

        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }

        if(q.size()==0 && fresh>0) return -1;

        int time = 0;

        int[][] dirs = {{-1,0},{1,0}, {0,1}, {0,-1}};

        while(fresh>0 && !q.isEmpty()){
            int s = q.size();
            for(int i = 0 ;i<s; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] dir: dirs){
                    int r = row+dir[0];
                    int c = col+dir[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0? time: -1;

    }
}
