//Tabulation - Optimized (Using only two rows)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> dp = new HashMap<>();
        dp.put(0,1);
        for(int i=0; i<n; i++){
            HashMap<Integer,Integer> nextDp = new HashMap<>();
            for(int key: dp.keySet()){
                int count = dp.get(key);
                nextDp.put(key-nums[i],nextDp.getOrDefault(key-nums[i],0) + count);
                nextDp.put(key+nums[i],nextDp.getOrDefault(key+nums[i],0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target,0);
    }
}
