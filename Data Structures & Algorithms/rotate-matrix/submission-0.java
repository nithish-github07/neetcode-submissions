//soln1 -> reverse and transpose
class Solution {
    public void rotate(int[][] matrix) {
        //reversing
        int n = matrix.length;
        for(int i=0; i<(n/2); i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }

        //transpose
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
