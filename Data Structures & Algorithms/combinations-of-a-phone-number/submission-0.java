class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        findCombination(digits,map,res,new StringBuilder(),0);
        return res;
    }
    public void findCombination(String digits,String[] map,List<String> res,StringBuilder sb,int ind){
        if(digits.length() == 0) return;
        if(ind == digits.length()){
            res.add(sb.toString());
            return;
        }
        int dig = digits.charAt(ind) - '0';
        for(char ch: map[dig].toCharArray()){
            sb.append(ch);
            findCombination(digits,map,res,sb,ind+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
