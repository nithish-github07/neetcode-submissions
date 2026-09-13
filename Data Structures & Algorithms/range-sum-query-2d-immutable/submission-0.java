class NumMatrix {

    int[][] mat;
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m + 1][n + 1];
        for(int i=0; i<m; i++){
            int pre = 0;
            for(int j=0; j<n; j++){
                pre += matrix[i][j];
                int above = prefix[i][j+1];
                prefix[i+1][j+1] = pre + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {  
        row1 = row1 + 1; col1 = col1 + 1; row2 = row2 + 1; col2 = col2 + 1;

        int bottomRight = prefix[row2][col2];
        int above = prefix[row1 - 1][col2];
        int left = prefix[row2][col1 - 1];
        int topLeft = prefix[row1-1][col1-1]; //topleft is added because it is subtracted twice

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */