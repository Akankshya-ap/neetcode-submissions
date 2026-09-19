class Solution {
    private int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for(int i= 0; i<c; i++){
            pacQ.add(new int[]{0,i});
            atlQ.add(new int[]{r-1,i});
        }

        for(int i = 0; i<r; i++){
            pacQ.add(new int[]{i,0});
            atlQ.add(new int[]{i, c-1});
        }

        bfs(pacQ, pac, heights);
        bfs(atlQ, atl, heights);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] h, int[][] heights){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            h[r][c] = true;

            for(int[] d: dirs){
                int row = r+d[0], col = c+d[1];
                if(row>=0 && col>=0 && row<heights.length && col<heights[0].length && !h[row][col] && heights[row][col]>=heights[r][c]){
                    q.add(new int[]{row, col});
                }
            }
        }
    }
}
