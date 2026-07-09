class Solution {
    public int diagonalSum(int[][] mat) {
        int col = 0;
        int sum = 0;
        for(int i=0; i<mat.length; i++){
            if(col == mat.length - 1 - col){
                sum += mat[i][col++];
                continue;
            }
            sum += mat[i][col] + mat[i][mat.length -1 - col];
            col++;
        }
        return sum;
    }
}