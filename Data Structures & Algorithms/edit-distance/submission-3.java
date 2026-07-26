//tabulation - optimized
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n+1];
        for(int i=n; i>=0; i--){
            dp[i] = n-i;
        }
        for(int i=m-1; i>=0; i--){
            int[] nextDp = new int[n+1];
            for(int j=n; j>=0; j--){
                if(j == n){
                    nextDp[j] = 1 + dp[j];
                    continue;
                }
                if(word1.charAt(i) == word2.charAt(j)){
                    nextDp[j] = dp[j+1];
                    continue;
                }
                nextDp[j] = 1 + Math.min(Math.min(nextDp[j+1],dp[j+1]),dp[j]);
            }
            dp = nextDp;
        }
        return dp[0];
    }
}
