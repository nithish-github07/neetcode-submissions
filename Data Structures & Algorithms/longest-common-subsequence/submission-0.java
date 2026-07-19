// Top-Down DP Approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0,0,text1,text2,memo);
    }
    public int dfs(int i, int j, String text1, String text2, int[][] memo){
        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        

        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + dfs(i+1,j+1,text1,text2,memo);
            return memo[i][j];
        }
        else{
            memo[i][j] = Math.max(dfs(i+1,j,text1,text2,memo),dfs(i,j+1,text1,text2,memo));
            return memo[i][j];
        }
    }
}
