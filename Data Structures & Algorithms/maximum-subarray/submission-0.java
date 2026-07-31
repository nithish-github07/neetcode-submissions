class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int currmax = 0;
        for(int i=0; i<nums.length; i++){
            currmax = Math.max(currmax + nums[i],nums[i]);
            
            res = Math.max(res,currmax);
        }
        return res;
    }
}
