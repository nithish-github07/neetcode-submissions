class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        int n = heights.length;
        for(int i=0; i<n; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int area = top[1] * (i - top[0]);
                maxArea = Math.max(maxArea, area);
                start = top[0];
            }
            stack.push(new int[]{start,heights[i]});
        }

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int area = top[1] * (n - top[0]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
