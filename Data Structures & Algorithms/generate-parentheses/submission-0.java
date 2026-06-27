class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        parantheses(n,res,new StringBuilder(),0,0);
        return res;
    }
    public void parantheses(int n, List<String> res, StringBuilder sb, int open, int close){
        if(close > open) return;
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            parantheses(n,res,sb,open+1,close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < n){
            sb.append(')');
            parantheses(n,res,sb,open,close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
