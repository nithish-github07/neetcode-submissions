class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        int m = word1.length(), n = word2.length();
        while(i < m && j < n){
            sb.append(word1.charAt(i)).append(word2.charAt(j));
            i++; j++;
        }
        while(i < m){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < n){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}