class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        int n = s.length();
        for(int r = 0; r < n; r++){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r),r);
            res = Math.max(res,(r-l+1));
        }
        return res;
    }
}
