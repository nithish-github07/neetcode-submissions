class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        for(int i=0; i<s.length(); i++){
            dp[i] = -1;
        }
        dp[s.length()] = 1;
        return dfs(s,0,dp);
    }
    public int dfs(String s, int i, int[] dp){
        if(dp[i] != -1){
            return dp[i];
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        int res = dfs(s,i+1,dp);
        if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1)-'0' <=6))){
            res += dfs(s,i+2,dp);
        }

        dp[i] = res;
        return res;
    }

}
