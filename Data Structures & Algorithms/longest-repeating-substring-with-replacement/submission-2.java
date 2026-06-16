class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l =0, r = 0, n = s.length();
        int res = 0;
        int maxf = 1;
        while(r < n){
            freq[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf,freq[s.charAt(r)-'A']);
            if((r-l+1) - maxf > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
   