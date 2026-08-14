//soln2
class Solution {
    public void rotate(int[][] matrix) {
       int l = 0, r = matrix.length - 1;
       while(l < r){ //doing in reverse
        int t = l, b = r;
        for(int i=0; i<(r - l); i++){
            int topleft = matrix[t][l+i];

            matrix[t][l+i] = matrix[b-i][l];
            matrix[b-i][l] = matrix[b][r-i];
            matrix[b][r-i] = matrix[t+i][r];

            matrix[t+i][r] = topleft;
        }
        l++;
        r--;
       }
    }
}
