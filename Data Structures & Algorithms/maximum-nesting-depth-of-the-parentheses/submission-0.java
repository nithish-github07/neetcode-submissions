class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                count++;
                max = Math.max(count,max);
            }
            else if(ch == ')'){
                count--;
            }
        }
        return max;
    }
}