class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                else if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }

        for(int i=0; i<9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[j][i] == '.') continue;
                else if(set.contains(board[j][i])) return false;
                else set.add(board[j][i]);
            }
        }

        for(int sq = 0; sq < 9; sq++){
            HashSet<Character> set = new HashSet<>();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int row = (sq/3)*3 + i;
                    int col = (sq%3)*3 + j;
                    if(board[row][col] == '.') continue;
                    else if(set.contains(board[row][col])) return false;
                    else set.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
