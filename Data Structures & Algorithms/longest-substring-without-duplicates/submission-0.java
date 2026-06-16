class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0, r = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        while(r < n){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            else{
                int length = (r - l  + 1);
                maxLength = Math.max(maxLength,length);
                set.add(s.charAt(r));
                r++;
            }
        }
        return maxLength;
    }
}
