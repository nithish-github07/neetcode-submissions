class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String str: tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                switch(str){
                    case "+":
                        stack.push(String.valueOf(op1 + op2));
                        break;
                    case "-":
                        stack.push(String.valueOf(op1 - op2));
                        break;
                    case "*":
                        stack.push(String.valueOf(op1 * op2));
                        break;
                    case "/":
                        stack.push(String.valueOf(op1 / op2));
                        break;
                }
            }
            else{
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
