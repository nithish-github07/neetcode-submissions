class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int offset = 1;
        for(int i=1; i<=n; i++){
            if(offset * 2 == i){
                dp[i] = 1;
                offset = i;
                continue;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}
