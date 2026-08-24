//backtracking + cache
class Solution {
    int m,n;
    HashMap<String,Boolean> dp;
    public boolean isMatch(String s, String p) {
        dp = new HashMap<>();
        m = s.length(); n = p.length();
        return dfs(0,0,s,p);
    }
    public boolean dfs(int i, int j, String s, String p){
        if(i >= m && j >= n){
            return true;
        }
        if(j >= n){
            return false;
        }
        String key = i + "-" + j;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        boolean match = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) ? true : false;

        if((j + 1 < n) && p.charAt(j+1) == '*'){
            dp.put(key, dfs(i,j+2,s,p) || (match && dfs(i+1,j,s,p)));
            return dp.get(key);
        }

        if(match){
            dp.put(key, dfs(i+1,j+1,s,p));
            return dp.get(key);
        }

        dp.put(key, false);
        return false;
    }
}
