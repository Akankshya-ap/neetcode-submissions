class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m+1][n+1];

        // dp[1][1] = 1;

        // for(int i = 1; i<=m ; i++){
        //     for(int j = 1; j<=n; j++){
        //         dp[i][j] += dp[i-1][j]+dp[i][j-1];
        //     }
        // }
        // return dp[m][n];

        int[] row = new int[n];
        Arrays.fill(row,1);

        for(int i = 0;i<m-1; i++){
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for(int j = n-2; j>=0; j--){
                newRow[j] = newRow[j+1] + row[j];
            }
            row = newRow;
        }
        return row[0];

    }
}
