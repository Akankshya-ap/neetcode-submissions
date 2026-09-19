class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int r = 0; r<row; r++){
            if(board[r][0]=='O'){
                dfs(board, r, 0, row, col);
            }
            if(board[r][col-1]=='O'){
                dfs(board, r, col-1, row, col);
            }
        }

        for(int c = 0; c<col; c++){
            if(board[0][c]=='O'){
                dfs(board, 0, c, row, col);
            }
            if(board[row-1][c] == 'O'){
                dfs(board, row-1, c, row, col);
            }
        }

        for(int r = 0; r<row; r++){
            for(int c = 0; c<col; c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
                if(board[r][c]=='T'){
                    board[r][c]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, int row, int col){
        if(r<0 || c<0 || r>=row || c>=col || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';

        dfs(board, r+1, c, row, col);
        dfs(board, r, c+1, row, col);
        dfs(board, r-1, c, row, col);
        dfs(board, r, c-1, row, col);
    }

}
