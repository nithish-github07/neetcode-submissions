class Solution {
    int m,n;
    int[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;
        cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row,-1);
        }
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res = Math.max(res,backtrack(i,j,matrix,-1));
            }
        }
        return res;
    }
    public int backtrack(int i, int j, int[][] matrix, int prev){
        if(i<0 || j<0 || i>=m || j>=n || matrix[i][j] <= prev){
            return -1;
        }
        if(cache[i][j] != -1) return cache[i][j];
        int val = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k=0; k<4; k++){
            int ni = i + dir[k][0], nj = j + dir[k][1];
            val = Math.max(val,backtrack(ni,nj,matrix,matrix[i][j]));
        }
        cache[i][j] = 1 + val;
        return 1 + val;
        
    }
}
