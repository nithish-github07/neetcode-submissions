//memoization - using cache
class Solution {
    int m,n;
    int[][] cache;
    public int minDistance(String word1, String word2) {
        m = word1.length(); n = word2.length();
        cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row,-1);
        }
        return minop(0,0,word1,word2);
    }
    public int minop(int i, int j, String word1, String word2){
        if(i >= m){
            return n - j;
        }
        if(j >= n){
            return m - i;
        }
        if(cache[i][j] != -1) return cache[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return minop(i+1,j+1,word1,word2);
        }
        int res = Math.min(minop(i,j+1,word1,word2), minop(i+1,j,word1,word2)); //insert or delete
        res = Math.min(res,minop(i+1,j+1,word1,word2)); //replace

        cache[i][j] = 1 + res;

        return 1 + res;
    }
}
