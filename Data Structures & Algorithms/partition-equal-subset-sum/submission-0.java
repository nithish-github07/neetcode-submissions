//Backtracking + Memoization
class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % 2 != 0) return false;
        memo = new Boolean[nums.length][sum/2 + 1];
        return dfs(nums,0,sum/2);
    }
    public boolean dfs(int[] nums, int ind, int target){
        if(ind == nums.length){
            return target == 0;
        }
        if(target < 0){
            return false;
        }
        if(memo[ind][target] != null){
            return memo[ind][target];
        }
        memo[ind][target] = dfs(nums,ind+1,target) || dfs(nums,ind+1,target-nums[ind]);
        return memo[ind][target];
    }
}
