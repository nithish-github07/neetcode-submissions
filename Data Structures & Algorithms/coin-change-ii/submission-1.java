class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return dfs(amount,coins,dp,0);             
    }
    public int dfs(int amount, int[] coins,int[][] dp, int ind){
        if(amount==0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int res = 0;
        for(int i=ind; i<coins.length; i++){
            res += dfs(amount-coins[i],coins,dp,i);
        }
        dp[ind][amount] = res;
        return res;
    }
}
