class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a: asteroids){
            while(!stack.isEmpty() && stack.peek() > 0 && a < 0){
                int diff = stack.peek() + a;
                if(diff > 0){
                    a = 0;
                }
                else if(diff < 0){
                    stack.pop();
                }
                else{
                    a = 0;
                    stack.pop();
                }
            }
            if(a != 0) stack.push(a);
        }
        int[] res = new int[stack.size()];
        int i = 0;
        for(int num: stack){
            res[i++] = num;
        }
        return res;
    }
}