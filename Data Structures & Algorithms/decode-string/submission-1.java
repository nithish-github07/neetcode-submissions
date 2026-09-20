class Solution {
    public String decodeString(String x) {
        Stack<String> s = new Stack<>();
        for(char ch: x.toCharArray()){
            if(ch != ']'){
                s.push(String.valueOf(ch));
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(!s.peek().equals("[")){
                    sb.insert(0,s.pop());
                }
                s.pop();

                //Building the number
                String num = "";
                while(!s.isEmpty() && Character.isDigit(s.peek().charAt(0))){
                    num = s.pop() + num;
                }
                int n = Integer.parseInt(num);

                //Building the string to  push 
                StringBuilder str = new StringBuilder();
                for(int i=0; i<n; i++){
                    str.append(sb);
                }
                s.push(str.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while(!s.isEmpty()){
            res.insert(0,s.pop());
        }
        return res.toString();
    }
}