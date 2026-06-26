class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(backTrack(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean backTrack(char[][] board, String word, int i, int j, int ind){
        if(ind == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(ind)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = backTrack(board,word,i-1,j,ind+1) || backTrack(board,word,i+1,j,ind+1) || 
                        backTrack(board,word,i,j-1,ind+1) || backTrack(board,word,i,j+1,ind+1);

        board[i][j] = temp;
        return found; 
    }
}
