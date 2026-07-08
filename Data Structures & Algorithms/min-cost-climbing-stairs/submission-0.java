class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = cost[n-1], b = 0;
        for(int i=n-2; i>=0; i--){
            int temp = a;
            a = Math.min(cost[i]+a, cost[i]+b);
            b = temp;
        }
        return Math.min(a,b);
    }
}
