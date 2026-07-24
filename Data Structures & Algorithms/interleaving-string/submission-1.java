//Basic Memoization using cache
class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return backTrack(0,0,0,s1,s2,s3);
    }
    public boolean backTrack(int i, int j, int k, String s1, String s2, String s3){
        if(k >= s3.length()) return true;
        if(dp[i][j] != null) return dp[i][j];
        boolean res = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            res = backTrack(i+1,j,k+1,s1,s2,s3);
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            res = backTrack(i,j+1,k+1,s1,s2,s3);
        }
        dp[i][j] = res;
        return res;
    }
}
