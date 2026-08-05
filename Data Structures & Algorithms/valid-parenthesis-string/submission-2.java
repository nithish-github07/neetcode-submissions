class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> lp = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                lp.push(i);
            }
            else if(s.charAt(i) == '*'){
                star.push(i);
            }
            else{
                if(!lp.isEmpty()){
                    lp.pop();
                }
                else if(!star.isEmpty()){ //star is considered as left paranthesis
                    star.pop();
                }
                else{
                    return false;
                }
            }
            
        }
        while(!lp.isEmpty() && !star.isEmpty() && lp.peek() < star.peek()){ //star is considered as right paranthesis
            lp.pop();
            star.pop();
        }

        return lp.isEmpty();
    }
}
