class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    if(j - i + 1 > resLen){
                        resLen = j-i+1;
                        resIdx = i;
                    }
                }
            }
        }
        return s.substring(resIdx,(resIdx + resLen));
    }
}
