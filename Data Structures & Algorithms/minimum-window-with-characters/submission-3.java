class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int n = s.length();
        int residx = -1;
        int minLen = n + 1;
        HashMap<Character,Integer> freq1 = new HashMap<>();
        HashMap<Character,Integer> freq2 = new HashMap<>();
        for(char ch: t.toCharArray()){
            freq2.put(ch,freq2.getOrDefault(ch,0) + 1);
        }
        int resmatch = freq2.size();
        int l = 0, matches = 0;
        for(int r = 0; r < n; r++){
            char ch = s.charAt(r);
            freq1.put(ch,freq1.getOrDefault(ch,0) + 1);
            if(freq2.containsKey(ch) && freq2.get(ch).equals(freq1.get(ch))){ //note this .equals() - this is a solution for large inputs
                matches++;
            }
            if(matches != resmatch) continue;
            while(l <= r && matches == resmatch){
                if((r-l+1) < minLen){
                    minLen = r-l+1;
                    residx = l;
                }
                char lch = s.charAt(l);
                freq1.put(lch,freq1.get(lch)-1);
                if(freq2.containsKey(lch) && freq1.get(lch) < freq2.get(lch)){
                    matches--;
                }
                l++;

            }
            
        }
        return (residx == -1 ? "" : s.substring(residx,residx + minLen));
    }
}
