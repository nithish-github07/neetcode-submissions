//Optimal memoization
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
        if(ind == coins.length){
            return 0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        dp[ind][amount] = dfs(amount-coins[ind],coins,dp,ind) + dfs(amount,coins,dp,ind+1);
        return dp[ind][amount];
    }
}
