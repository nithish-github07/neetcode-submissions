class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                else if((ch == ')' && stack.peek() != '(') || (ch == ']' && stack.peek() != '[') || (ch == '}' && stack.peek() != '{')) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
