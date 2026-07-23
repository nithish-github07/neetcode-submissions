//Tabulation
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer>[] dp = new HashMap[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = new HashMap<>();
        }
        dp[0].put(0,1);
        for(int i=0; i<n; i++){
            for(int key: dp[i].keySet()){
                int count = dp[i].get(key);
                dp[i+1].put(key-nums[i],dp[i+1].getOrDefault(key-nums[i],0) + count);
                dp[i+1].put(key+nums[i],dp[i+1].getOrDefault(key+nums[i],0) + count);
            }
        }
        return dp[n].getOrDefault(target,0);
    }
}
