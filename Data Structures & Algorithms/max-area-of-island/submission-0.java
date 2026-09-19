class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[] res = new int[1];
        int max = 0;
        for(int i = 0;i <grid.length; i++){
            for(int j = 0;j<grid[0].length; j++){
                if(grid[i][j]==1){
                    dfs(grid, i, j, res);
                    max = Math.max(max, res[0]);
                    res[0] = 0;
                }

            }
        }
        return max;
    }
}


private void dfs(int[][] grid, int i, int j, int[] res){
    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '*'){
        return ;
    }
    if(grid[i][j] == 1) {grid[i][j] = 0;
    res[0]++;

    dfs(grid, i+1, j, res);
    dfs(grid, i-1, j, res);
    dfs(grid, i, j+1, res);
    dfs(grid, i, j-1, res);}

}