class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!Character.isLetterOrDigit(ch1)) i++;
            else if(!Character.isLetterOrDigit(ch2)) j--;
            else if(Character.toLowerCase(ch1) == Character.toLowerCase(ch2)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}