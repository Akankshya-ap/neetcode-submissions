class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int l = 0, r = n-1;

        while(row<m && l<=r){
            int mid = l + ((r-l)/2);
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid]>target) r=mid-1;
            else if(matrix[row][mid]<target){
                if(matrix[row][n-1]<target){
                    row++;
                    l=0;
                    r=n-1;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return false;


    }
}
