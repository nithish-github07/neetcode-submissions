class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String s: operations){
            if(s.equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2);
                stack.push(n1);
                stack.push(n1 + n2);
            }
            else if(s.equals("D")){
                int n = stack.peek();
                stack.push(n * 2);
            }
            else if(s.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}