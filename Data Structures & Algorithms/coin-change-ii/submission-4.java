//O(m*n) - Tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length, n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }   
        for(int i=0; i<n; i++){
            dp[m][i] = 0;
        }

        for(int i=m-1; i>=0; i--){
            for(int j=1; j<=n; j++){
                dp[i][j] =dp[i+1][j];
                if(j-coins[i] >= 0){
                    dp[i][j] +=  dp[i][j-coins[i]];
                }
            }
        }  
        return dp[0][n];
    }

}
