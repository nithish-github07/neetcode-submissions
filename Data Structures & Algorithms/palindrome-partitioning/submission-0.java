class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        palpartition(s,res,new ArrayList<>(),0);
        return res;
    }
    public void palpartition(String s, List<List<String>> res, List<String> part, int ind){
        if(ind >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int i = ind; i<s.length(); i++){
            if(isPalindrome(s,ind,i)){
                part.add(s.substring(ind,i+1));
                palpartition(s,res,part,i+1);
                part.remove(part.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
