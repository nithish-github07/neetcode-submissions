//tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        dp[m][n] = 1;
        for(int i=m-1; i>=0; i--){
            for(int j=n; j>=0; j--){
                dp[i][j] = dp[i+1][j];
                if(j < n && s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
        
    }
}
