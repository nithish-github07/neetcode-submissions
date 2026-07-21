//Caching using DP
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        HashMap<String,Integer> cache = new HashMap<>();
        return dfs(0,true,prices,cache);
    }
    public int dfs(int i, boolean canBuy, int[] prices, HashMap<String,Integer> cache){
        if(i >= prices.length){
            return 0;
        }
        String key = i + "-" + canBuy;
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int cooldown = dfs(i+1,canBuy,prices,cache);
        if(canBuy){
            int buy = dfs(i+1,!canBuy,prices,cache) - prices[i];
            cache.put(key,Math.max(buy,cooldown));
        }
        else{
            int sell = dfs(i+2,!canBuy,prices,cache) + prices[i];
            cache.put(key,Math.max(sell,cooldown));
        }
        return cache.get(key);
    }
}
