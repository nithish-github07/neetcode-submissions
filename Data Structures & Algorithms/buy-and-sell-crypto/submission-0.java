class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int l = 0;
        int n = prices.length;
        for(int r=1; r<n; r++){
            if(prices[r] < prices[l]) l=r;
            else{
                maxprofit = Math.max(maxprofit,(prices[r] - prices[l]));
            }
        }
        return maxprofit;
    }
}