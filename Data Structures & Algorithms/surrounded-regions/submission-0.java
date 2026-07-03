class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        for(int i=0; i<cols; i++){
            notCapture(0,i,board);
            notCapture(rows-1,i,board);
        }
        for(int i=0; i<rows; i++){
            notCapture(i,0,board);
            notCapture(i,cols-1,board);
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O') capture(i,j,board);
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    public void notCapture(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '#';
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k=0; k<4; k++){
            int ni = i + d[k][0], nj = j + d[k][1];
            notCapture(ni,nj,board);
        }
    }
    public void capture(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'X';
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k=0; k<4; k++){
            int ni = i + d[k][0], nj = j + d[k][1];
            capture(ni,nj,board);
        }
    }
}
