class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0;i <grid.length; i++){
            for(int j = 0;j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '*'){
            return ;
        }
        if(grid[i][j] == '1') {grid[i][j] = '*';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);}
    
    }
}
