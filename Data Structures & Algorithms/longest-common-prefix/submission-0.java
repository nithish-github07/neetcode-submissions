//horizontal scanning
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int n = strs.length;
        for(int i=1; i<n; i++){
            int j = 0;
            String str = strs[i];
            int minLength = Math.min(res.length(), str.length());
            while(j < minLength){
                if(res.charAt(j) != str.charAt(j)){
                    break;
                }
                j++;
            }
            res = res.substring(0,j);
        }
        return res;
    }
}