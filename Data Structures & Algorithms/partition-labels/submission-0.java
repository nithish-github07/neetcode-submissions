class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int[] freq = new int[26];      
        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a'] = i;
        }
        int upper = -1;
        int afterlast = 0;
        for(int i=0; i<n; i++){
            upper = Math.max(upper,freq[s.charAt(i) - 'a']);
            if(i == upper){
                res.add(i - afterlast + 1);
                afterlast = i + 1;
            }
        }
        return res;
    }
}
