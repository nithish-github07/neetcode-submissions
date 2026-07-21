//O(n) - Optimized Tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length, n = amount;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i=m-1; i>=0; i--){
            int[] nextDp = new int[amount +1 ];
            nextDp[0] = 1;
            for(int j=1; j<=n; j++){
                nextDp[j] = dp[j];
                if(j - coins[i] >= 0){
                    nextDp[j] += nextDp[j-coins[i]];
                }
            }
            dp = nextDp;
        }

        return dp[n];
    }

}
