//memoization
class Solution {
    int m,n;
    int[][] cache;
    public int numDistinct(String s, String t) {
        m = s.length(); n=t.length();
        cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row,-1);
        }
        return distinctSub(0,0,s,t);
    }
    public int distinctSub(int i, int j, String s, String t){
        if(j >= n){
            return 1;
        }
        if(i >= m){
            return 0;
        }
        if(cache[i][j] != -1) return cache[i][j];
        int res = distinctSub(i+1,j,s,t);
        if(s.charAt(i) == t.charAt(j)){
            res += distinctSub(i+1,j+1,s,t);
        }
        cache[i][j] = res;
        return res;
    }
}
