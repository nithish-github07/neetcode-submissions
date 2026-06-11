class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0; int high = m * n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int col = mid % n;
            int row = mid / n;
            if(target == matrix[row][col]) return true;
            else if(target < matrix[row][col]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}
