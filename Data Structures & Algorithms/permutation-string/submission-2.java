class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int matches = 0;
        for(int i=0; i<s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq1[i] == freq2[i]) matches++;
        }
        int l=0, r=s1.length()-1;
        int n = s2.length();
        while(r < n-1){
            if(matches == 26) return true;
            int indl = s2.charAt(l) - 'a';
            freq2[indl]--;
            if(freq2[indl] == freq1[indl]){
                matches++;
            }
            else if(freq1[indl] - 1 == freq2[indl]){
                matches--;
            }
            l++;
            r++;
            int indr = s2.charAt(r) - 'a';
            freq2[indr]++;
            if(freq2[indr] == freq1[indr]){
                matches++;
            }
            else if(freq1[indr] + 1 == freq2[indr]){
                matches--;
            }
        }

        return matches == 26;
    }
}
