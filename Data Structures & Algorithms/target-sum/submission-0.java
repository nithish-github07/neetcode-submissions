//Memoization Technique
class Solution {
    HashMap<String,Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return dfs(nums,target,0,0);
    }
    public int dfs(int[] nums, int target, int total, int i){
        if(i == nums.length){
            return (total == target) ? 1 : 0;
        }
        String key = i + "-" + total;
        if(map.containsKey(key)){
            return map.get(key);
        }
        map.put(key,dfs(nums,target,total + nums[i],i+1) + dfs(nums,target,total-nums[i],i+1));
        return map.get(key);
    }
}
