class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr,(a,b) -> b[0]-a[0]);
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<n; i++){
            stack.push((double)(target-arr[i][0]) / arr[i][1]);
            if(stack.size() >= 2){
                Double top = stack.pop();
                if(top > stack.peek()){
                    stack.push(top);
                }
            }
        }
        return stack.size();

    }
}
