//space optimized tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=m-1; i>=0; i--){
            int[] nextDp = new int[n+1];
            for(int j=n; j>=0; j--){
                nextDp[j] = dp[j];
                if(j < n && s.charAt(i) == t.charAt(j)){
                    nextDp[j] += dp[j+1];
                }
            }
            dp = nextDp;
        }
        return dp[0];
    }
}
